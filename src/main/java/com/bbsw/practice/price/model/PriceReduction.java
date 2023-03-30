package com.bbsw.practice.price.model;

import com.bbsw.practice.item.model.Item;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pricereduction")
public class PriceReduction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricereductionsequence")
    @SequenceGenerator(name="pricereductionsequence", sequenceName = "pricereductionsequence", allocationSize = 1, schema = "erp")
    @Column(name="idpricereduction")
    Long idPriceReduction;

    @Column(name="reducedprice")
    BigDecimal reducedPrice;

    @Column(name="startdate")
    Date startDate;

    @Column(name="enddate")
    Date endDate;

    @ManyToOne
    @JoinColumn(name="iditem")
    @JsonBackReference("priceitem")
    Item item;

}
