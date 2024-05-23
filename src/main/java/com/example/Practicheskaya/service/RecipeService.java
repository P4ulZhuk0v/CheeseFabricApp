package com.example.Practicheskaya.service;


import com.example.Practicheskaya.dao.RecipeDAO;
import com.example.Practicheskaya.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeDAO recipeDAO;

    public void save(Recipe recipe) {
        recipeDAO.save(recipe);
    }
}
