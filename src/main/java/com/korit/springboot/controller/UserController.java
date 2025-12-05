package com.korit.springboot.controller;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<?> create(@Valid @RequestBody CreateUserReqDto dto) {
        userService.createUser(dto);
        return ResponseEntity.ok().build();
    }


}
