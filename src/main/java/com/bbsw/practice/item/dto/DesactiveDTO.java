package com.bbsw.practice.item.dto;

import com.bbsw.practice.item.ReasonEnum;
import com.bbsw.practice.user.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DesactiveDTO {
    ReasonEnum reason;
    LocalDate register;
    @JsonBackReference("desactiveitem")
    ItemDTO item;
    @JsonBackReference("desactiveuser")
    UserDTO user;
}
