package com.example.Practicheskaya.entity;

import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "cheese")
public class Cheese {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cheese_name")
    private String cheeseName;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    @Min(value = 1, message = "Введите положительное целое число")
    private int amount;

    @Column(name="date")
    private String dateOfProducing;


    public Cheese(){}

    @PrePersist
    public void getDate(){
        dateOfProducing = DateParser.getLocalDate();
    }


    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateOfProducing() {
        return dateOfProducing;
    }

    public void setDateOfProducing(String dateOfProducing) {
        this.dateOfProducing = dateOfProducing;
    }

    public Long getId() {
        return id;
    }
}
