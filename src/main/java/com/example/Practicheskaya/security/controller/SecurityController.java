package com.example.Practicheskaya.security.controller;

import com.example.Practicheskaya.security.entity.UserDets;
import com.example.Practicheskaya.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "security/login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new UserDets());
        model.addAttribute("errorMessage", "");
        return "security/registration";
    }


    @PostMapping("/perform_registration")
    public String performRegistration(@ModelAttribute(name = "user") UserDets user, Model model){
        if(userService.findAllByPhoneNumber(user.getPhoneNumber()) != null){
            model.addAttribute("user", new UserDets());
            return "redirect:/registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/login";
    }
}
