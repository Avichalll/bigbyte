package com.davil.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davil.user_service.model.RestaurantOwner;

public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner,Integer> {
    
}
