package com.example.Practicheskaya.dao;

import com.example.Practicheskaya.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheeseDAO extends JpaRepository<Cheese, Long> {

    Cheese findByCheeseName(String cheeseName);

    void deleteByCheeseName(String cheeseName);

}
