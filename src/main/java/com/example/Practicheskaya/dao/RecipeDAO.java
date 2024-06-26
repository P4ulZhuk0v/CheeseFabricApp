package com.example.Practicheskaya.dao;

import com.example.Practicheskaya.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe, Long>{
    List<Recipe> findAllByCheeseName(String cheeseName);
}
