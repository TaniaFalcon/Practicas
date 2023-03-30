package com.bbsw.practice.user.dto;

import com.bbsw.practice.item.dto.DesactiveDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    String username;
    String password;
    @JsonManagedReference("desactiveuser")
    List<DesactiveDTO> desactiveDTOList;

}
