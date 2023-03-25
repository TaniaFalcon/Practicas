package com.bbsw.practice.supplier.model;

import com.bbsw.practice.item.model.ItemData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="supplier_data")
public class SupplierData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplierSquence")
    @SequenceGenerator(name="supplierSequence", sequenceName = "supplierSequence", allocationSize = 1, schema = "erp")
    @Column(name="supplier_id")
    Long id;

    @Column(name="name", unique = true)
    String name;

    @Column(name="country")
    String country;

    @ManyToMany(mappedBy = "item_data", cascade = CascadeType.ALL)
    List<ItemData> itemDataList;

}
