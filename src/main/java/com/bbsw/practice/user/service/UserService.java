package com.bbsw.practice.user.service;

import com.bbsw.practice.user.dto.UserDTO;
import com.bbsw.practice.user.model.UserData;
import com.bbsw.practice.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();

    public void saveUser(UserDTO dto){
        userRepository.save(modelMapper.map(dto, UserData.class));
    }

    public boolean login(UserDTO dto){
        return modelMapper.map(dto, UserData.class).getUsername().equals(userRepository.findByUsername(modelMapper.map(dto, UserData.class).getUsername()).getUsername());
    }
}
