package com.davil.user_service.service;

import com.davil.user_service.DTO.RequestDTO.UserRequestDTO;
import com.davil.user_service.DTO.ResponseDTO.UserResponseDTO;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userRequestDTO);
    
}
