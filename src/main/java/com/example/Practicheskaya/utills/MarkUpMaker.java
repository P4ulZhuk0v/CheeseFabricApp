package com.example.Practicheskaya.utills;

import org.springframework.stereotype.Component;

@Component
public class MarkUpMaker {
    public Double makeMarkup(double price, int markup){
        return (price*(100+markup))/100;
    }
}
