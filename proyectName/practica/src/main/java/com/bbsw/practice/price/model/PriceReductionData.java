package com.bbsw.practice.price.model;

import com.bbsw.practice.item.model.ItemData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="pricereductiondata")
public class PriceReductionData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priceReductionSquence")
    @SequenceGenerator(name="priceReductionSequence", sequenceName = "priceReductionSequence", allocationSize = 1, schema = "erp")
    @Column(name="idpricereduction")
    Long idPriceReduction;

    @Column(name="reducedprice")
    BigDecimal reducedPrice;

    @Column(name="startdate")
    Date startDate;

    @Column(name="enddate")
    Date endDate;

    @ManyToOne
    @JoinColumn(name="item_id")
    ItemData itemData;

}
