package com.example.Practicheskaya.utils;

import com.example.Practicheskaya.security.entity.UserDets;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentSessionGetter {
    public static UserDets getCurrentSession(){
        return (UserDets) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
