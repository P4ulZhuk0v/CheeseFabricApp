package com.example.Practicheskaya.entity;

import com.example.Practicheskaya.utils.DateParser;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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

    @Column(name="markUp")
    @Min(value = 0, message = "Please, enter value between 0 and 100")
    @Max(value = 100, message = "Please, enter value between 0 and 100")
    private int markUp;

    @Column(name="markUpPrice")
    private Double markUpPrice;

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

    public int getMarkUp() {
        return markUp;
    }

    public void setMarkUp(int markUp) {
        this.markUp = markUp;
    }

    public Double getMarkUpPrice() {
        return markUpPrice;
    }

    public void setMarkUpPrice(Double markUpPrice) {
        this.markUpPrice = markUpPrice;
    }

    public Long getId() {
        return id;
    }


}
