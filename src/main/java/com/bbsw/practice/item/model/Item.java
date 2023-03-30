package com.bbsw.practice.item.model;

import com.bbsw.practice.item.StateEnum;
import com.bbsw.practice.price.model.PriceReduction;
import com.bbsw.practice.supplier.model.Supplier;
import com.bbsw.practice.user.model.UserData;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="itemdata")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsequence")
    @SequenceGenerator(name="itemsequence", sequenceName = "itemsequence", allocationSize = 1, schema = "erp")
    @Column(name="iditem")
    Long idItem;

    @Column(name="itemcode", unique = true, nullable = false)
    BigDecimal itemCode;

    @Column(name="description", nullable = false)
    String description;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    StateEnum state;

    @Column(name="price")
    BigDecimal price;

    @Column(name="creationdate")
    LocalDate creationDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="username",nullable = false,referencedColumnName = "iduser")
    @JsonBackReference("useritem")
    UserData userdata;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="item_supplier",
        joinColumns = @JoinColumn(name = "iditem"),
        inverseJoinColumns = @JoinColumn(name = "idsupplier"))
    List<Supplier> supplierList;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference("priceitem")
    List<PriceReduction> priceReductionList;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference("desactiveitem")
    List<Desactive> desactiveList;

    public void addPriceReductionList(List<PriceReduction> priceReductionList){
        priceReductionList.forEach(this::addPriceReduction);
    }
    public void addPriceReduction(PriceReduction priceReduction){
        if(priceReductionList==null){
            priceReductionList=new ArrayList<>();
        }
        priceReduction.setItem(this);
        priceReductionList.add(priceReduction);
    }
    public void addSupplierList(List<Supplier> supplierList){
        supplierList.forEach(this::addSupplier);
    }
    public void addSupplier(Supplier supplier){
        if(supplierList==null){
            supplierList=new ArrayList<>();
        }
        supplierList.add(supplier);
        supplier.addItem(this);
    }
}
