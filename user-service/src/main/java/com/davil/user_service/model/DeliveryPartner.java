package com.davil.user_service.model;

import com.davil.user_service.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter

@Entity
@Table(name = "deliveryPartner")

public class DeliveryPartner extends BaseEntity {

    private String firstName;
    
    private String lastName;
    
    private String email;
    
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
    
    @NotBlank(message = "Aadhar number is required")
    @Pattern(regexp = "^[0-9]{12}$", message = "Aadhar number must be 12 digits")
    private String aadharNumber;
    
    @NotBlank(message = "Driving license number is required")
    private String drivingLicenseNumber;
    
    @NotBlank(message = "Vehicle type is required")
    private String vehicleType; // BIKE, SCOOTER, CAR
    
    @NotBlank(message = "Vehicle registration number is required")
    private String vehicleRegistrationNumber;
    
    @NotBlank(message = "Address is required")
    private String address;
    
    @NotBlank(message = "City is required")
    private String city;
    
    @NotBlank(message = "PIN code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "PIN code must be 6 digits")
    private String pinCode;
    
    @NotBlank(message = "Bank account number is required")
    private String bankAccountNumber;
    
    @NotBlank(message = "IFSC code is required")
    private String ifscCode;
    
    private String emergencyContactName;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Emergency contact must be 10 digits")
    private String emergencyContactNumber;

    
    
}
