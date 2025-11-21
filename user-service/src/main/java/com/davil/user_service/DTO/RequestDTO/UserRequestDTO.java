package com.davil.user_service.dto.RequestDTO;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

    @NotBlank(message = "First name is required")
    String firstName,

    @NotBlank(message = "Last name is required")
    String lastName,

    @NotBlank(message = "Invalid Email")
    String email

) {
} 
