package com.davil.user_service.mapper;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.davil.user_service.dto.RequestDTO.RestaurantOwnerRegistrationRequestDTO;
import com.davil.user_service.model.RestaurantOwner;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantOwnerMapper {

    private final AddressMapper addressMapper;


    public RestaurantOwner toRestaurantOwner(RestaurantOwnerRegistrationRequestDTO restaurantOwnerRegistrationRequestDTO){

        if(restaurantOwnerRegistrationRequestDTO==null){
            // throw new BadRequestException();
        }

        return RestaurantOwner.builder()
        .ownerFirstName(restaurantOwnerRegistrationRequestDTO.ownerFirstName())
        .ownerFirstName(restaurantOwnerRegistrationRequestDTO.ownerLastName())
        .email(restaurantOwnerRegistrationRequestDTO.email())
        .phoneNumber(restaurantOwnerRegistrationRequestDTO.phoneNumber())
        .restaurantName(restaurantOwnerRegistrationRequestDTO.restaurantName())
        .businessRegistrationNumber(restaurantOwnerRegistrationRequestDTO.businessRegistrationNumber())
        .fssaiLicenseNumber(restaurantOwnerRegistrationRequestDTO.fssaiLicenseNumber())
        .gstNumber(restaurantOwnerRegistrationRequestDTO.gstNumber())
        .ifscCode(restaurantOwnerRegistrationRequestDTO.ifscCode())
        .panNumber(restaurantOwnerRegistrationRequestDTO.panNumber())
        .addresses(Collections.singletonList(addressMapper.toAddress(restaurantOwnerRegistrationRequestDTO.addressRequestDTO())))
        
        .build();
    }
    
    
}
