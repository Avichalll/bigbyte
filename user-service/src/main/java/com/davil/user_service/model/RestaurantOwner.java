package com.davil.user_service.model;

import java.util.List;

import com.davil.user_service.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter

@SuperBuilder
@Entity
@Table(name = "restaurantOwner")

public class RestaurantOwner extends BaseEntity {

    private String ownerFirstName;
    
    private String ownerLastName;
    
    private String email;
    
    private String password;
    
    private String phoneNumber;
    
    private String restaurantName;
    
    private String businessRegistrationNumber;
    
    private String fssaiLicenseNumber;
    
    private String gstNumber;
    
    private String bankAccountNumber;
    
    private String ifscCode;
    
    private String panNumber;

    @OneToMany(mappedBy= "restaurantOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Address> addresses;

    
    
}
