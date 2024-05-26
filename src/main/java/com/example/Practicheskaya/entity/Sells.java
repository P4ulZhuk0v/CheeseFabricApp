package com.example.Practicheskaya.entity;

import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

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
    @Min(value = 1, message = "Введите положительное целое число")
    private int amountOfSells;

    @Column(name = "price")
    private Double price;
    @Column(name = "date")
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

    public Long getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
