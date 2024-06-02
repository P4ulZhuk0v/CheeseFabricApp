package com.example.Practicheskaya.security.DAO;

import com.example.Practicheskaya.security.entity.UserDets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserDets, Long> {
    UserDets findByPhoneNumber(String phoneNumber);
}
