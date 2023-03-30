package com.bbsw.practice.item.controller;

import com.bbsw.practice.item.StateEnum;
import com.bbsw.practice.item.dto.DesactiveDTO;
import com.bbsw.practice.item.dto.ItemDTO;
import com.bbsw.practice.item.model.Desactive;
import com.bbsw.practice.item.model.Item;
import com.bbsw.practice.item.service.ItemService;
import com.bbsw.practice.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<List<ItemDTO>> list(){
        return new ResponseEntity<>(itemService.list(), HttpStatus.OK);
    }

    @GetMapping("/listbystate")
    public ResponseEntity<List<ItemDTO>> listByState(@RequestParam StateEnum state){
        return new ResponseEntity<>(itemService.listByState(state), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Item> create(@RequestBody ItemDTO itemDTO,@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(itemService.create(itemDTO,userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modify")
    public ResponseEntity<Item> modify(@RequestParam BigDecimal itemCode, @RequestBody ItemDTO itemDTO, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(itemService.modify(itemCode,itemDTO,userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/desactive")
    public ResponseEntity<Desactive> desactive(@RequestParam StateEnum state, @RequestBody DesactiveDTO dtoDesactive) throws IOException {
        return new ResponseEntity<>(itemService.desactive(state,dtoDesactive), HttpStatus.CREATED);
    }
}
