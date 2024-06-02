package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Recipe;
import com.example.Practicheskaya.service.CheeseService;
import com.example.Practicheskaya.service.MaterialsService;
import com.example.Practicheskaya.service.RecipeService;
import com.example.Practicheskaya.utills.RecipeDeleter;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private MaterialsService materialsService;


    @Autowired
    private RecipeDeleter recipeDeleter;

    @GetMapping("/add-recipe")
    public String addRecipe(Model model){
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("materialsNames", materialsService.getMaterialsNames());
        return "AddRecipe";
    }



    @PostMapping("/recipe-added")
    public String recipeAdded(@Valid @ModelAttribute(name="recipe") Recipe recipe, BindingResult bindingResult, Model model){
        boolean isPresent = false;
        for(Recipe recipe1: recipeService.findAllByCheeseName(recipe.getCheeseName())){
            if(recipe1.getMaterialName().equals(recipe.getMaterialName())){
                isPresent=true;
            }
        }
        if(bindingResult.hasErrors()||isPresent){
            model.addAttribute("materialsNames", materialsService.getMaterialsNames());
            return "AddRecipe";
        }

        recipeService.save(recipe);
        return "redirect:/shop/stats";
    }

    @GetMapping("/observe-recipes")
    public String observeResipe(Model model){
        model.addAttribute("cheeseNames", recipeService.getAvailibleRecipesNames());
        model.addAttribute("recipes", recipeService.findAll());
        return "ObserveRecipe";
    }


    @GetMapping("/delete-recipe")
    public String deleteRecipe(Model model){
        return "DeleteRecipe";
    }

    @PostMapping("/recipe-deleted")
    public String recipeDeleted(@RequestParam("cheese") String cheeseName, @RequestParam("material") String materialName){
        recipeDeleter.deleteRecipe(cheeseName, materialName);
        return "redirect:/shop/stats";
    }

//    @PostMapping("/recipe-deleted")
//    public String recipeDeleted(@RequestParam("cheese") String cheeseName, @RequestParam("material") String materialName){
//        System.out.println(1);
//        recipeDeleter.deleteRecipe(cheeseName, materialName);
//        return "redirect:/shop/stats";
//    }






}
