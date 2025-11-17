package com.davil.user_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.davil.user_service.user.User;

public interface UserRepository extends MongoRepository<User,String> {
    
}
