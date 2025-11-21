package com.davil.user_service.model;


import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.davil.user_service.common.BaseEntity;
import com.davil.user_service.enums.AccountStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@SuperBuilder

@Entity
@Table(name = "user")

public class User extends BaseEntity implements UserDetails, Principal {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "Email", unique = true)
    private String email;


    @Column(length = 255) 
    private String password;

    private boolean accountLocked;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role!=null && role.getUserRole()!=null ){
            return Collections.singletonList(new SimpleGrantedAuthority(role.getUserRole().name()));
        }
        return Collections.emptyList();

    }

     @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    private List<Token> tokens;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private Role role;

    
}
