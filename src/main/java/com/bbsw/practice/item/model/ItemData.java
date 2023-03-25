package com.bbsw.practice.item.model;

import com.bbsw.practice.item.StateEnum;
import com.bbsw.practice.price.model.PriceReductionData;
import com.bbsw.practice.supplier.model.SupplierData;
import com.bbsw.practice.user.model.UserData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="item_data")
public class ItemData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSequence")
    @SequenceGenerator(name="itemSequence", sequenceName = "itemSequence", allocationSize = 1, schema = "erp")
    @Column(name="item_id")
    Long id;

    @Column(name="item_code", unique = true)
    BigDecimal itemCode;

    @Column(name="description")
    String description;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    StateEnum state;

    @Column(name="price")
    BigDecimal price;

    @Column(name="creation_date")
    LocalDate creationDate;

    @Column(name="username")
    String username;

    @ManyToMany
    @JoinTable(name="item_supplier",
        joinColumns = @JoinColumn(name = "item_id"),
        inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    List<SupplierData> supplierDataList;

    @OneToMany(mappedBy = "itemData", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PriceReductionData> priceReductionDataList;

    @ManyToOne
    @JoinColumn(name="user_id")
    UserData userData;

}
