package com.davil.user_service.model;

import java.util.List;

import com.davil.user_service.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "customer")

public class Customer extends BaseEntity {

    private String firstName;
    
    private String lastName;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "restaurentOwner", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Address> addresses;
    
    
}
