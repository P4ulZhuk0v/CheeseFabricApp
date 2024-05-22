package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Cheese;
import com.example.Practicheskaya.service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;

@RequestMapping("/cheese")
@Controller
public class CheeseController {

    @Autowired
    private CheeseService cheeseService;


    @RequestMapping("/add-cheese")
    public String addCheese(Model model){
        model.addAttribute("cheese", new Cheese());
        return "AddCheesePage";
    }

    @PostMapping("/cheese-added")
    public RedirectView redirectOnMainPage(@ModelAttribute(name="cheese") Cheese cheese){
        cheeseService.addCheese(cheese);
        return new RedirectView("/shop/stats");
    }
}