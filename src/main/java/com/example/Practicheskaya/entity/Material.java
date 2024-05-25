package com.example.Practicheskaya.entity;


import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "currencyName")
    private String currencyName;

    @Column(name = "rub_price")
    private int rub_price;

    @Column(name = "date")
    private String date;

    @Column(name="amount")
    private long amount;

    @PrePersist
    public void persist(){
        date = DateParser.getLocalDate();
    }

    public Material(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }
}
