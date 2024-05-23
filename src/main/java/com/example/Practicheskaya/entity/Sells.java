package com.example.Practicheskaya.entity;

import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="sells")
public class Sells {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "cheese_name")
    private String cheeseName;

    @Column(name = "amount_of_sells")
    private int amountOfSells;


    @Column(name = "date", nullable = false)
    private String date;

    @PrePersist
    public void persist(){
        date = DateParser.getLocalDate();
    }

    public Sells(){}


    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public int getAmountOfSells() {
        return amountOfSells;
    }

    public void setAmountOfSells(int amountOfSells) {
        this.amountOfSells = amountOfSells;
    }

    public String getDate() {
        return date;
    }
}
