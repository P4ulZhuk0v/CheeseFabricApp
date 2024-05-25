package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Sells;
import com.example.Practicheskaya.service.CheeseService;
import com.example.Practicheskaya.service.SellsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/sells")
public class SellsController {

    @Autowired
    private SellsService sellsService;

    @Autowired
    private CheeseService cheeseService;

    @RequestMapping("/add-sell")
    public String addSell(Model model){
        model.addAttribute("cheeseNames", cheeseService.getCheeseNames());
        model.addAttribute("sell", new Sells());
        return "AddSellsPage";
    }


    @PostMapping("/sell-added")
    public String sellAdded(@Valid @ModelAttribute("sell") Sells sells, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("cheeseNames", cheeseService.getCheeseNames());
            return "AddSellsPage";
        }
        sellsService.saveSells(sells);
        return "redirect:/shop/stats";
    }
}
