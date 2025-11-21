package com.davil.user_service.service;

import com.davil.user_service.dto.RequestDTO.UserRequestDTO;
import com.davil.user_service.dto.ResponseDTO.UserResponseDTO;

public interface UserService {

    UserResponseDTO create(UserRequestDTO userRequestDTO);
    
}
