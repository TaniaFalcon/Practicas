package com.bbsw.practice.item.service;

import com.bbsw.practice.item.StateEnum;
import com.bbsw.practice.item.dto.DesactiveDTO;
import com.bbsw.practice.item.dto.ItemDTO;
import com.bbsw.practice.item.model.Desactive;
import com.bbsw.practice.item.model.Item;
import com.bbsw.practice.item.repository.DesactiveRepository;
import com.bbsw.practice.item.repository.ItemRepository;
import com.bbsw.practice.price.dto.PriceReductionDTO;
import com.bbsw.practice.price.model.PriceReduction;
import com.bbsw.practice.supplier.dto.SupplierDTO;
import com.bbsw.practice.supplier.model.Supplier;
import com.bbsw.practice.supplier.repository.SupplierRepository;
import com.bbsw.practice.user.dto.UserDTO;
import com.bbsw.practice.user.model.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    DesactiveRepository desactiveRepository;

    ModelMapper modelMapper = new ModelMapper();
    Type type = new TypeToken<List<PriceReduction>>() {}.getType();
    Gson gson = new GsonBuilder().create();

    public List<ItemDTO> list(){ //Funciona correctamente
        return itemRepository.findAll().stream().map(item -> {
            ItemDTO itemDTO = modelMapper.map(item,ItemDTO.class);
            itemDTO.setUsername(modelMapper.map(item.getUserdata(), UserDTO.class));
            itemDTO.getUsername().setDesactiveDTOList(item.getUserdata().getDesactive().stream().map(desactive -> modelMapper.map(desactive, DesactiveDTO.class)).toList());
            itemDTO.setPriceReductionDTOList(item.getPriceReductionList().stream().map(priceReduction -> modelMapper.map(priceReduction, PriceReductionDTO.class)).toList());
            itemDTO.setSupplierDTOList(item.getSupplierList().stream().map(supplier -> modelMapper.map(supplier, SupplierDTO.class)).toList());
            itemDTO.setDesactiveDTOList(item.getDesactiveList().stream().map(desactive -> modelMapper.map(desactive, DesactiveDTO.class)).toList());
            return itemDTO;
        }).toList();
    }
    public List<ItemDTO> listByState(StateEnum state){ //Funciona correctamente
        return itemRepository.findByState(state).stream().map(item -> {
            ItemDTO itemDTO = modelMapper.map(item,ItemDTO.class);
            itemDTO.setUsername(modelMapper.map(item.getUserdata(), UserDTO.class));
            itemDTO.getUsername().setDesactiveDTOList(item.getUserdata().getDesactive().stream().map(desactive -> modelMapper.map(desactive, DesactiveDTO.class)).toList());
            itemDTO.setPriceReductionDTOList(item.getPriceReductionList().stream().map(priceReduction -> modelMapper.map(priceReduction, PriceReductionDTO.class)).toList());
            itemDTO.setSupplierDTOList(item.getSupplierList().stream().map(supplier -> modelMapper.map(supplier, SupplierDTO.class)).toList());
            itemDTO.setDesactiveDTOList(item.getDesactiveList().stream().map(desactive -> modelMapper.map(desactive, DesactiveDTO.class)).toList());
            return itemDTO;
        }).toList();
    }
    public Item create(ItemDTO itemDTO, UserDTO userDTO){
        if(itemDTO.getItemCode() == null && itemDTO.getDescription() == null){
            throw new NullPointerException("Item Code or/and Description is empty");
        }
        itemDTO.setCreationDate(LocalDate.now());
        itemDTO.setUsername(userDTO);
        Item item = modelMapper.map(itemDTO,Item.class);
        if(item.getPriceReductionList()!=null&&!item.getPriceReductionList().isEmpty()){
            item.addPriceReductionList(item.getPriceReductionList());
        }
        if(item.getSupplierList()!=null&&!item.getSupplierList().isEmpty()){
            item.addSupplierList(item.getSupplierList());
        }
        item.setDesactiveList(itemDTO.getDesactiveDTOList().stream().map(desactive -> modelMapper.map(desactive, Desactive.class)).toList());
        return itemRepository.save(item);
    }
    public Item modify(BigDecimal itemCode, ItemDTO dtoItem, UserDTO userDTO){
        Item itemModif = itemRepository.findByItemCode(itemCode);
        if(dtoItem.getState() == StateEnum.ACTIVE && dtoItem.getDescription() != null){
            itemModif.setUserdata(modelMapper.map(userDTO, UserData.class));
            itemModif.setDescription(dtoItem.getDescription());
            itemModif.setState(dtoItem.getState());
            itemModif.setPrice(dtoItem.getPrice());
            itemModif.setCreationDate(LocalDate.now());
        }
        if(dtoItem.getPriceReductionDTOList() != null) {
            /*itemModif.addPriceReductionList(gson.fromJson(gson.toJson(dtoItem.getPriceReductionDTOList()), type));*/

            /*itemModif.addPriceReductionList(dtoItem.getPriceReductionDTOList().stream().map(priceReductionDTO ->
                    modelMapper.map(priceReductionDTO, PriceReduction.class)).toList());*/

            /*dtoItem.getPriceReductionDTOList().forEach(priceReductionDTO -> {
                PriceReduction priceReduction = new PriceReduction(null, priceReductionDTO.getReducedPrice(), priceReductionDTO.getStartDate(), priceReductionDTO.getEndDate(), null);
                itemModif.addPriceReduction(priceReduction);
            });*/
        }

        //Utilizar el metodo del repository de supplier
        List<String> names = new ArrayList<>();
        dtoItem.getSupplierDTOList().forEach(supplierDTO -> {
            names.add(supplierDTO.getName());
        });
        List<Supplier> supplierList = supplierRepository.findByNameIn(names);
        itemModif.addSupplierList(supplierList);
        /*itemModif.getSupplierList().forEach(supplierData -> {
            if(!supplierData.getName().equals(item.getSupplierList().getName())){
                itemModif.getSupplierList().add(modelMapper.map(dtoSupplier, Supplier.class));
            }
        });*/
        return itemRepository.save(itemModif);
    }
    public Desactive desactive(StateEnum state, DesactiveDTO dtoDesactive) throws IOException {
        Desactive desactiveData = modelMapper.map(dtoDesactive, Desactive.class);
        if(state != StateEnum.DISCONTINUED){
            throw new IOException("Item not discontinued");
        }
        desactiveRepository.save(desactiveData);
        return desactiveData;
    }
}
