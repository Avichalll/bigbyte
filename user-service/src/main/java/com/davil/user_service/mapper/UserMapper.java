package com.davil.user_service.mapper;

import org.springframework.stereotype.Service;

import com.davil.user_service.dto.RequestDTO.UserRequestDTO;
import com.davil.user_service.dto.ResponseDTO.CustomerResponseDTO;
import com.davil.user_service.dto.ResponseDTO.UserResponseDTO;
import com.davil.user_service.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMapper {



    public User toUser(UserRequestDTO userRequestDTO){
        return User.builder()
        .firstName(userRequestDTO.firstName())
        .lastName(userRequestDTO.lastName())
        .email(userRequestDTO.email())
        .build();
    }

    public UserResponseDTO toUserResponseDTO(User user){

        return UserResponseDTO.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .build();

    }

    public CustomerResponseDTO toCustomerRegistrationResponseDTO(User user){
        return CustomerResponseDTO.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .build();
    }

    
}
