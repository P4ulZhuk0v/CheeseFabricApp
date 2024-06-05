package com.example.Practicheskaya.security.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_SELLER, ROLE_STORAGE_WORKER, ROLE_CHEESE_PRODUCER, ROLE_ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
