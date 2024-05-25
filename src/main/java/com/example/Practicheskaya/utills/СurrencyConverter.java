package com.example.Practicheskaya.utills;

import com.example.Practicheskaya.entity.Material;
import com.example.Practicheskaya.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Component
public class СurrencyConverter {

    @Autowired
    private MyRestClient myRestClient;

    public Material parseCurrencyInMaterial(Material material){
        String currencyName = material.getCurrencyName();
        int price = material.getPrice();
        Double course = myRestClient.getConnection(DateParser.getLocalDate()).findOnSiteByPattern().get(currencyName);
        material.setRub_price(course * price);
        return material;
    }

}
