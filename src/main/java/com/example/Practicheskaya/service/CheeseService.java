package com.example.Practicheskaya.service;

import com.example.Practicheskaya.dao.CheeseDAO;
import com.example.Practicheskaya.entity.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheeseService {

    @Autowired
    private CheeseDAO cheeseDAO;

    public void addCheese(Cheese cheese){
        cheeseDAO.save(cheese);
    }

    public Cheese getCheeseByName(String name){
        return cheeseDAO.findByCheeseName(name);
    }


    public List<Cheese> getAllCheese(){
        return cheeseDAO.findAll();
    }

    public void deleteCheese(String cheeseName){
        cheeseDAO.deleteByCheeseName(cheeseName);
    }
}
