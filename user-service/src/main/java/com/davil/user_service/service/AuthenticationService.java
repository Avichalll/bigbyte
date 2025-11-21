package com.davil.user_service.service;

import com.davil.user_service.common.ApiResponse;
import com.davil.user_service.dto.RequestDTO.CustomerRegistrationRequestDTO;
import com.davil.user_service.dto.RequestDTO.RestaurantOwnerRegistrationRequestDTO;
import com.davil.user_service.dto.ResponseDTO.CustomerResponseDTO;
import com.davil.user_service.dto.ResponseDTO.RestaurantOwnerResponseDTO;

public interface AuthenticationService {

    ApiResponse<CustomerResponseDTO> registerCustomer(CustomerRegistrationRequestDTO customerRegistrationRequestDTO);

    ApiResponse<RestaurantOwnerResponseDTO> registerRestaurantOwner(RestaurantOwnerRegistrationRequestDTO restaurantOwnerRegistrationRequestDTO);
    
}
