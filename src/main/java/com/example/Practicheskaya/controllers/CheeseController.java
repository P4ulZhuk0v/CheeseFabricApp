package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Cheese;
import com.example.Practicheskaya.service.CheeseService;
import com.example.Practicheskaya.service.RecipeService;
import com.example.Practicheskaya.utills.CheeseFromMaterials;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;

@RequestMapping("/cheese")
@Controller
public class CheeseController {

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private CheeseFromMaterials cheeseFromMaterials;

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/add-cheese")
    public String addCheese(Model model){
        model.addAttribute("recipes", recipeService.getAvailibleRecipesNames());
        model.addAttribute("cheese", new Cheese());
        return "AddCheesePage";
    }

    @PostMapping("/cheese-added")
    public String redirectOnMainPage(@Valid @ModelAttribute(name="cheese") Cheese cheese, BindingResult bindingResult, Model model){
        double rub_price;
        if(bindingResult.hasErrors()||(rub_price = cheeseFromMaterials.produceCheeseFromMaterials(cheese.getCheeseName(), cheese.getAmount()))==0){
            model.addAttribute("recipes", recipeService.getAvailibleRecipesNames());
            return "AddCheesePage";
        }
        cheese.setPrice(rub_price);
        cheeseService.addCheese(cheese);
        return "redirect:/shop/stats";
    }
}
