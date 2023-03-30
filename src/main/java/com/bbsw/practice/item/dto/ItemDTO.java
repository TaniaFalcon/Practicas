package com.bbsw.practice.item.dto;


import com.bbsw.practice.item.StateEnum;
import com.bbsw.practice.price.dto.PriceReductionDTO;
import com.bbsw.practice.supplier.dto.SupplierDTO;
import com.bbsw.practice.user.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ItemDTO {
    BigDecimal itemCode;
    String description;
    StateEnum state;
    BigDecimal price;
    LocalDate creationDate;
    UserDTO username;
    List<PriceReductionDTO> priceReductionDTOList;
    List<SupplierDTO> supplierDTOList;
    @JsonManagedReference("desactiveitem")
    List<DesactiveDTO> desactiveDTOList;
}
