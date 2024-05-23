package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Cheese;
import com.example.Practicheskaya.entity.Material;
import com.example.Practicheskaya.entity.Recipe;
import com.example.Practicheskaya.service.CheeseService;
import com.example.Practicheskaya.service.MaterialsService;
import com.example.Practicheskaya.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private MaterialsService materialsService;


    @RequestMapping("/add-recipe")
    public String addRecipe(Model model){
        //добавить recipe, cheesename, materialname
        model.addAttribute("recipe", new Recipe());

        model.addAttribute("cheeseNames", getCheeseNames());

        model.addAttribute("materialsNames", getMaterialsNames());
        return "AddRecipe";
    }



    @PostMapping("/recipe-added")
    public RedirectView recipeAdded(@ModelAttribute(name="recipe") Recipe recipe){
        recipeService.save(recipe);
        return new RedirectView("/shop/stats");
    }


    private Set<String> getCheeseNames(){
        Set<String> cheeseNames = new HashSet<>();
        for(Cheese cheese: cheeseService.getAllCheese()){
            cheeseNames.add(cheese.getCheeseName());
        }
        return cheeseNames;
    }

    private Set<String> getMaterialsNames(){
        Set<String> materialNames = new HashSet<>();
        for(Material material: materialsService.getAllMaterials()){
            materialNames.add(material.getName());
        }
        return materialNames;
    }

    @RequestMapping("/observe-recipes")
    public String observeResipe(Model model){
        model.addAttribute("cheeseNames", getAvailibleRecipesNames());
        model.addAttribute("recipes", recipeService.findAll());
        return "ObserveRecipe";
    }

    private Set<String> getAvailibleRecipesNames() {
        Set<String> names = new HashSet<>();
        for(Recipe recipe: recipeService.findAll()){
            names.add(recipe.getCheeseName());
        }
        return names;
    }


}
