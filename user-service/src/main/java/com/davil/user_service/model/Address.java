package com.davil.user_service.model;

import com.davil.user_service.common.BaseEntity;
import com.davil.user_service.enums.AddressType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter

@Table(name = "address")
@Entity

public class Address extends BaseEntity {

    private AddressType addressType;
    private String country;
    private String address1;
    private String address2;

    private String city;
    private String pincode;
    private String state;
    private String flatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantOwnerId")
    private RestaurantOwner restaurantOwner ;


    


}
