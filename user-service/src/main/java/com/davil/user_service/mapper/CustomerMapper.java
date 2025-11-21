package com.davil.user_service.mapper;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.davil.user_service.dto.RequestDTO.CustomerRegistrationRequestDTO;
import com.davil.user_service.model.Customer;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor

public class CustomerMapper {

    private final AddressMapper addressMapper;
    
    public Customer toCustomer(CustomerRegistrationRequestDTO customerRegistrationRequestDTO){
        return Customer.builder()
        .firstName(customerRegistrationRequestDTO.firstName())
        .lastName(customerRegistrationRequestDTO.lastName())
        .email(customerRegistrationRequestDTO.email())
        .addresses(Collections.singletonList(addressMapper.toAddress(customerRegistrationRequestDTO.addressRequestDTO())))
        .build();
        
    }

}
