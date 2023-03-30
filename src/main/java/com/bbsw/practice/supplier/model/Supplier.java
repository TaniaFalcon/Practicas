package com.bbsw.practice.supplier.model;

import com.bbsw.practice.item.model.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suppliersequence")
    @SequenceGenerator(name="suppliersequence", sequenceName = "suppliersequence", allocationSize = 1, schema = "erp")
    @Column(name="idsupplier")
    Long idSupplier;

    @Column(name="name", unique = true)
    String name;

    @Column(name="country")
    String country;

    @ManyToMany(mappedBy = "supplierList", cascade = CascadeType.ALL)
    List<Item> itemList;

    public void addItem(Item item){
        if(itemList==null){
            itemList=new ArrayList<>();
        }
        itemList.add(item);
    }
}
