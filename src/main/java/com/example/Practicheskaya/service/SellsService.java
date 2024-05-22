package com.example.Practicheskaya.service;

import com.example.Practicheskaya.dao.SellsDAO;
import com.example.Practicheskaya.entity.Sells;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellsService {

    private final SellsDAO sellsDAO;


    public List<Sells> getAllSells(){
        return sellsDAO.findAll();
    }

    public void saveSells(Sells sells){
        sellsDAO.save(sells);
    }
}
