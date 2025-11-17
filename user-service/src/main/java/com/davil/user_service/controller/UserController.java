package com.davil.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davil.user_service.DTO.RequestDTO.UserRequestDTO;
import com.davil.user_service.DTO.ResponseDTO.UserResponseDTO;
import com.davil.user_service.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@Valid
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserResponseDTO> create(@RequestBody  UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.create(userRequestDTO));
    }

}
