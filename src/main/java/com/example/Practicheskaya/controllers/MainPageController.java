package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Cheese;
import com.example.Practicheskaya.entity.Material;
import com.example.Practicheskaya.entity.Recipe;
import com.example.Practicheskaya.entity.Sells;
import com.example.Practicheskaya.service.CheeseService;
import com.example.Practicheskaya.utills.СurrencyConverter;
import com.example.Practicheskaya.service.MaterialsService;
import com.example.Practicheskaya.service.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class MainPageController {

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private MaterialsService materialsService;

    @Autowired
    private SellsService sellsService;

    @GetMapping("/stats")
    public String cheeseFabric(Model model){
        List<Cheese> cheese = cheeseService.getAllCheese();
        model.addAttribute("cheese", cheese);

        List<Material> materials = materialsService.getAllMaterials();
        model.addAttribute("materials", materials);

        List<Sells> sells = sellsService.getAllSells();
        model.addAttribute("sells", sells);

        return "MainPage";
    }


    @PostMapping("/add-cheese")
    public RedirectView produceCheese(){
        return new RedirectView("/cheese/add-cheese");
    }

    @PostMapping("/add-material")
    public RedirectView buyMaterial(){
        return new RedirectView("/materials/add-material");
    }

    @PostMapping("/add-sell")
    public RedirectView sell(){
        return new RedirectView("/sells/add-sell");
    }


    @GetMapping("/add-recipe")
    public RedirectView addRecipe(){
        return new RedirectView("/recipes/add-recipe");
    }

    @GetMapping("/observe-recipes")
    public RedirectView observeRecipes(){
        return new RedirectView("/recipes/observe-recipes");
    }
}
