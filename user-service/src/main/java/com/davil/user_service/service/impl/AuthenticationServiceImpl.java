package com.davil.user_service.service.impl;

import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.davil.user_service.common.ApiResponse;
import com.davil.user_service.dto.RequestDTO.CustomerRegistrationRequestDTO;
import com.davil.user_service.dto.RequestDTO.RestaurantOwnerRegistrationRequestDTO;
import com.davil.user_service.dto.ResponseDTO.CustomerResponseDTO;
import com.davil.user_service.dto.ResponseDTO.RestaurantOwnerResponseDTO;
import com.davil.user_service.enums.AccountStatus;
import com.davil.user_service.enums.UserRole;
import com.davil.user_service.exception.DuplicateEmailException;
import com.davil.user_service.mapper.AddressMapper;
import com.davil.user_service.mapper.CustomerMapper;
import com.davil.user_service.mapper.RestaurantOwnerMapper;
import com.davil.user_service.mapper.UserMapper;
import com.davil.user_service.model.RestaurantOwner;
import com.davil.user_service.model.Role;
import com.davil.user_service.model.User;
import com.davil.user_service.repository.RestaurantOwnerRepository;
import com.davil.user_service.repository.RoleRepository;
import com.davil.user_service.repository.TokenRepository;
import com.davil.user_service.repository.UserRepository;
import com.davil.user_service.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomerMapper customerMapper;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final RestaurantOwnerMapper restaurantOwnerMapper;
    private final AddressMapper addressMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ApiResponse<CustomerResponseDTO> registerCustomer(
            CustomerRegistrationRequestDTO customerRegistrationRequestDTO) {

        throw new UnsupportedOperationException("Unimplemented method 'register'");

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ApiResponse<RestaurantOwnerResponseDTO> registerRestaurantOwner(
            RestaurantOwnerRegistrationRequestDTO restaurentOwnerRegistrationRequestDTO) {

        try {
            if (userRepository.existsByEmail(restaurentOwnerRegistrationRequestDTO.email())) {
                throw new DuplicateEmailException(restaurentOwnerRegistrationRequestDTO.email());
            }

            Role role = roleRepository.findByUserRole(UserRole.RESTAURANT_OWNER).orElseGet(() -> {
                Role restaurantOwnerRole = Role.builder()
                        .userRole(UserRole.RESTAURANT_OWNER)
                        .build();
                return roleRepository.save(restaurantOwnerRole);
            });

            User user = User.builder()
                    .firstName(restaurentOwnerRegistrationRequestDTO.ownerFirstName())
                    .lastName(restaurentOwnerRegistrationRequestDTO.ownerLastName())
                    .email(restaurentOwnerRegistrationRequestDTO.email())
                    .password(passwordEncoder.encode(restaurentOwnerRegistrationRequestDTO.password()))
                    .accountStatus(AccountStatus.ACTIVE)
                    .accountLocked(false)
                    .build();
            user.setRole(role);

            RestaurantOwner restaurantOwner = restaurantOwnerMapper
                    .toRestaurantOwner(restaurentOwnerRegistrationRequestDTO);

            RestaurantOwner savedRestaurantOwner = Objects.requireNonNull(
                    restaurantOwnerRepository.save(restaurantOwner),
                    "Failed to save restaurant owner");

        } catch (Exception e) {

        }

        throw new UnsupportedOperationException("Unimplemented method 'registerRestaurentOwner'");

    }

}
