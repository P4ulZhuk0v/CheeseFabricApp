package com.example.Practicheskaya.service;

import com.example.Practicheskaya.dao.CheeseDAO;
import com.example.Practicheskaya.entity.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<String> getCheeseNames(){
        Set<String> cheeseNames = new HashSet<>();
        for(Cheese cheese: getAllCheese()){
            cheeseNames.add(cheese.getCheeseName());
        }
        return cheeseNames;
    }
}
