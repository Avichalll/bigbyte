package com.davil.user_service.mapper;

import org.springframework.stereotype.Service;

import com.davil.user_service.dto.RequestDTO.AddressRequestDTO;
import com.davil.user_service.model.Address;

@Service

public class AddressMapper {


    public Address toAddress(AddressRequestDTO addressRequestDTO){
        
        return Address.builder()
        .addressType(addressRequestDTO.addressType())
        .country(addressRequestDTO.country())
        .address1(addressRequestDTO.address1())
        .address2(addressRequestDTO.address2())
        .city(addressRequestDTO.city())
        .pincode(addressRequestDTO.pincode())
        .state(addressRequestDTO.state())
        .flatNumber(addressRequestDTO.flatNumber())

        
        .build();
    }
    
}
