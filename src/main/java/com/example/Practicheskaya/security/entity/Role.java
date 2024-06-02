package com.example.Practicheskaya.security.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
