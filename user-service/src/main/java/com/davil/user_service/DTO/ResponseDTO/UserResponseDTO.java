package com.davil.user_service.DTO.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class UserResponseDTO {

    private String id;

    private String firstName;
    
    private String lastName;
    
    private String email;


    
}
