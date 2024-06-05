package com.example.Practicheskaya.utils;

import com.example.Practicheskaya.entity.Recipe;
import com.example.Practicheskaya.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeDeleter {

    @Autowired
    private RecipeService recipeService;

    public void deleteRecipe(String cheeseName, String materialName){
        if(cheeseName!=null){
            List<Recipe> recipeList = recipeService.findAllByCheeseName(cheeseName);
            if((materialName == null || materialName.isEmpty()) && recipeList!=null){
                for(Recipe recipe: recipeList){
                    recipeService.delete(recipe);
                }
            }else if(recipeList!=null){
                for(Recipe recipe: recipeList){
                    if(recipe.getMaterialName().equals(materialName)){
                        recipeService.delete(recipe);
                    }
                }
            }
        }
    }

}
