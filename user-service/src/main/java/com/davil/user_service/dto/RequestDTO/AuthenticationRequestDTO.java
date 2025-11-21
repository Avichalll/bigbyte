package com.davil.user_service.dto.RequestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record AuthenticationRequestDTO(

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email address")
    String email,

    @NotBlank(message = "password cannot be blank")
    @Size(max = 100, message = "limit exceeds")
    String password


) {
} 