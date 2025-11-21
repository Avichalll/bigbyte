package com.davil.user_service.dto.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AuthenticationResponseDTO {
        
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
