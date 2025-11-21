package com.davil.user_service.dto.RequestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RestaurantOwnerRegistrationRequestDTO(
    
    @NotBlank(message = "Owner first name is required")
    String ownerFirstName,
    
    @NotBlank(message = "Owner last name is required")
    String ownerLastName,
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    String password,
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    String phoneNumber,
    
    @NotBlank(message = "Restaurant name is required")
    String restaurantName,
    
    @NotBlank(message = "Business registration number is required")
    String businessRegistrationNumber,
    
    @NotBlank(message = "FSSAI license number is required")
    String fssaiLicenseNumber,
    
    
    
    String gstNumber,
    
    @NotBlank(message = "Bank account number is required")
    String bankAccountNumber,
    
    @NotBlank(message = "IFSC code is required")
    String ifscCode,
    
    String panNumber,

    AddressRequestDTO addressRequestDTO
) {
}