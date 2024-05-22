package com.example.Practicheskaya.controllers;

import com.example.Practicheskaya.utills.MyRestClient;
import com.example.Practicheskaya.entity.Material;
import com.example.Practicheskaya.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
@RequestMapping("/materials")
public class MaterialsController {


    @Autowired
    private MyRestClient myRestClient;

    @Autowired
    private MaterialsService materialsService;


    private Set<String> currencies;


    @RequestMapping("/add-material")
    public String addMaterialGet(Model model){
        model.addAttribute("material", new Material());
        model.addAttribute("currencies", parseForSelectForm());
        return "AddMaterialPage";
    }

    private Set<String> parseForSelectForm() {
        if(currencies==null) {
            currencies = myRestClient.getConnection("").findOnSiteByPattern().keySet();
        }
        return currencies;
    }

    @PostMapping("/material-added")
    public RedirectView addNewMaterialPost(@ModelAttribute(name = "material") Material material){
        materialsService.save(material);
        return new RedirectView("/shop/stats");
    }


}
