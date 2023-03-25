package com.bbsw.practice.price.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class PriceReductionDTO {
    Long id;

    BigDecimal reducedPrice;

    Date startDate;

    Date endDate;
}
