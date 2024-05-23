package com.example.Practicheskaya.dao;

import com.example.Practicheskaya.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDAO extends JpaRepository<Recipe, Long>{}
