package com.davil.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davil.user_service.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);
    
}
