package com.davil.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davil.user_service.enums.UserRole;
import com.davil.user_service.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findByUserRole(UserRole customer);
    
}
