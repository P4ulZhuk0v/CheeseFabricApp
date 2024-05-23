package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.entity.Sells;
import com.example.Practicheskaya.service.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/sells")
public class SellsController {

    @Autowired
    private SellsService sellsService;

    @RequestMapping("/add-sell")
    public String addSell(Model model){
        model.addAttribute("sell", new Sells());
        return "AddSellsPage";
    }


    @PostMapping("/sell-added")
    public RedirectView sellAdded(@ModelAttribute("sell") Sells sells){
        sellsService.saveSells(sells);
        return new RedirectView("/shop/stats");
    }
}
