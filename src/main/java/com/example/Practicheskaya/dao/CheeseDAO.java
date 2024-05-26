package com.example.Practicheskaya.dao;

import com.example.Practicheskaya.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheeseDAO extends JpaRepository<Cheese, Long> {

    Cheese findByCheeseName(String cheeseName);

    void deleteByCheeseName(String cheeseName);

    List<Cheese> findAllByCheeseNameOrderById(String name);

}
