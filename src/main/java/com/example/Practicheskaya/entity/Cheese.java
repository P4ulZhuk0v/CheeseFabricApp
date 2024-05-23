package com.example.Practicheskaya.entity;

import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;

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


    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDateOfProducing() {
        return dateOfProducing;
    }

    public void setDateOfProducing(String dateOfProducing) {
        this.dateOfProducing = dateOfProducing;
    }
}
