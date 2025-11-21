package com.davil.user_service.model;
import java.util.List;

import com.davil.user_service.common.BaseEntity;
import com.davil.user_service.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name= "role")

public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRole userRole; 

    @OneToMany( mappedBy = "role",fetch = FetchType.LAZY)
    private List<User> users;

    

    


}
