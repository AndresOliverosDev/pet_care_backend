package com.petsCare.index.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petsCare.index.dto.user.UserAddDTO;
import com.petsCare.index.services.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/add")
    ResponseEntity<String> add(@RequestBody UserAddDTO userAddDTO) {
        return userService.userAdd(userAddDTO);
    }
}
