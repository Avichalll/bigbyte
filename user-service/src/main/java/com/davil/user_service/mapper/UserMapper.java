package com.davil.user_service.mapper;

import org.springframework.stereotype.Service;

import com.davil.user_service.DTO.RequestDTO.UserRequestDTO;
import com.davil.user_service.DTO.ResponseDTO.UserResponseDTO;
import com.davil.user_service.user.User;

@Service
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

    
}
