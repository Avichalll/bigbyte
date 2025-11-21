package com.davil.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davil.user_service.common.ApiResponse;
import com.davil.user_service.dto.RequestDTO.CustomerRegistrationRequestDTO;
import com.davil.user_service.dto.RequestDTO.RestaurantOwnerRegistrationRequestDTO;
import com.davil.user_service.dto.ResponseDTO.CustomerResponseDTO;
import com.davil.user_service.dto.ResponseDTO.RestaurantOwnerResponseDTO;
import com.davil.user_service.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/v1/auth")
@RequiredArgsConstructor

public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/customer")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> registerCustomer(@RequestBody  CustomerRegistrationRequestDTO customerRegistrationRequestDTO){
        return ResponseEntity.ok(authenticationService.registerCustomer(customerRegistrationRequestDTO));
    }


    @PostMapping("/restaurant-owner")
    public ResponseEntity<ApiResponse<RestaurantOwnerResponseDTO>> registerRestaurantOwner(@RequestBody RestaurantOwnerRegistrationRequestDTO restaurantOwnerRegistrationRequestDTO){
        return ResponseEntity.ok(authenticationService.registerRestaurantOwner(restaurantOwnerRegistrationRequestDTO));
    }
 

    
}
