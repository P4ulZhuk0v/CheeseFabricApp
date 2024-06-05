package com.example.Practicheskaya.security.services;

import com.example.Practicheskaya.security.DAO.UserDAO;
import com.example.Practicheskaya.security.entity.Role;
import com.example.Practicheskaya.security.entity.UserDets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder encoder;

    public boolean createUser(UserDets userDets){
        if(userDAO.findByPhoneNumber(userDets.getPhoneNumber()) != null){
            return false;
        }
        userDets.setPassword(encoder.encode(userDets.getPassword()));
        userDets.setActive(true);
//        userDets.getRoles().add(Role.ROLE_USER);
        userDAO.save(userDets);
        return true;
    }

    public UserDets findAllByPhoneNumber(String phoneNumber){
        return userDAO.findByPhoneNumber(phoneNumber);
    }
}
