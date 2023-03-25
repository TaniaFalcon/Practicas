package com.bbsw.practice.item.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ItemDTO {
    Long id;

    String itemCode;

    String description;


    String state;


    BigDecimal price;

    LocalDate creationDate;

    String creator;
}
