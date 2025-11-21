package com.davil.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davil.user_service.model.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    
}
