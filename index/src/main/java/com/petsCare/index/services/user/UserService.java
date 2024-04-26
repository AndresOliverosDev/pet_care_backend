package com.petsCare.index.services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petsCare.index.dto.user.UserAddDTO;

@Service
public interface UserService {
    ResponseEntity<String> userAdd (UserAddDTO user);
}
