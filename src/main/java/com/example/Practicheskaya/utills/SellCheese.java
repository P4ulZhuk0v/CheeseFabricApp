package com.example.Practicheskaya.utills;

import com.example.Practicheskaya.entity.Cheese;
import com.example.Practicheskaya.service.CheeseService;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellCheese {
    @Autowired
    private CheeseService cheeseService;

    private List<Cheese> getAllCheeseByName(String cheeseName){
        return cheeseService.getAllByCheeseNameOrderById(cheeseName);
    }

    public double sellCheese(String cheeseName, int cheeseAmount){
        List<Cheese> cheeseList = getAllCheeseByName(cheeseName);
        double fullPrice = 0D;
        List<Cheese> toDelete = new ArrayList<>();
        for(Cheese cheese: cheeseList){
            if(cheese.getAmount() <= cheeseAmount){
                cheeseAmount-=cheese.getAmount();
                toDelete.add(cheese);
            }else{
                cheese.setAmount(cheese.getAmount() - cheeseAmount);
                fullPrice+=cheeseAmount*cheese.getPrice();
                cheeseService.addCheese(cheese);
                cheeseAmount=0;

            }
        }

        if(cheeseAmount==0){
            for(Cheese cheese: toDelete){
                cheeseService.deleteCheese(cheese);
                fullPrice+=cheese.getAmount()*cheese.getPrice();
            }
            return fullPrice;
        } else{
            return 0D;
        }

    }

}
