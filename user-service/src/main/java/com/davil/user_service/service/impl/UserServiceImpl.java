package com.davil.user_service.service.impl;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.davil.user_service.DTO.RequestDTO.UserRequestDTO;
import com.davil.user_service.DTO.ResponseDTO.UserResponseDTO;
import com.davil.user_service.mapper.UserMapper;
import com.davil.user_service.repository.UserRepository;
import com.davil.user_service.service.UserService;
import com.davil.user_service.user.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {

        try {

            User user = userMapper.toUser(userRequestDTO);
            if (user == null) {
                throw new BadRequestException("User not found");
            }

            User savedUser = userRepository.save(user);

            return userMapper.toUserResponseDTO(savedUser);

        } catch (Exception e) {

            throw new RuntimeException("Error creating user", e);
        }

    }

}
