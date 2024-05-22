package com.example.Practicheskaya.entity;

import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cheese")
@Data
public class Cheese {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cheese_name")
    private String cheeseName;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private long amount;

    @Column(name="date")
    private String dateOfProducing;


    public Cheese(){}

    @PrePersist
    public void getDate(){
        dateOfProducing = DateParser.getLocalDate();
    }





}
