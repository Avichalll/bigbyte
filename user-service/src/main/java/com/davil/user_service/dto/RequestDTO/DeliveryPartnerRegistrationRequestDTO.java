package com.davil.user_service.dto.RequestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DeliveryPartnerRegistrationRequestDTO(
    
    @NotBlank(message = "First name is required")
    String firstName,
    
    @NotBlank(message = "Last name is required")
    String lastName,
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    String password,
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    String phoneNumber,
    
    @NotBlank(message = "Aadhar number is required")
    @Pattern(regexp = "^[0-9]{12}$", message = "Aadhar number must be 12 digits")
    String aadharNumber,
    
    @NotBlank(message = "Driving license number is required")
    String drivingLicenseNumber,
    
    @NotBlank(message = "Vehicle type is required")
    String vehicleType, // BIKE, SCOOTER, CAR
    
    @NotBlank(message = "Vehicle registration number is required")
    String vehicleRegistrationNumber,
    
    @NotBlank(message = "Address is required")
    String address,
    
    @NotBlank(message = "City is required")
    String city,
    
    @NotBlank(message = "PIN code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "PIN code must be 6 digits")
    String pinCode,
    
    @NotBlank(message = "Bank account number is required")
    String bankAccountNumber,
    
    @NotBlank(message = "IFSC code is required")
    String ifscCode,
    
    String emergencyContactName,
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Emergency contact must be 10 digits")
    String emergencyContactNumber
) {
}