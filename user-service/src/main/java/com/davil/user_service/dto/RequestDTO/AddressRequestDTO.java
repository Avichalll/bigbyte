package com.davil.user_service.dto.RequestDTO;

import com.davil.user_service.enums.AddressType;

public record AddressRequestDTO(

        AddressType addressType,
        String country,
        String address1,
        String address2,
        String city,
        String pincode,
        String state,
        String flatNumber

) {

}
