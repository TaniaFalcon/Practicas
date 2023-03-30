package com.bbsw.practice.user.controller;

import com.bbsw.practice.user.dto.UserDTO;
import com.bbsw.practice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserDTO dto){
        return new ResponseEntity<>(userService.login(dto), HttpStatus.OK);
    }
}
