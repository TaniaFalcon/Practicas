package com.bbsw.practice.price.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceReductionDTO {
    BigDecimal reducedPrice;
    Date startDate;
    Date endDate;


}
