package com.example.Practicheskaya.entity;


import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Pattern(regexp = "[а-яА-Я ]+", message = "Имя не дожно содержать символов кроме русских букв и пробелов")
    private String name;

    @Column(name = "price")
    @Min(value = 1, message = "Введите положительное число")
    private int price;

    @Column(name = "currencyName")
    private String currencyName;

    public Double getRub_price() {
        return rub_price;
    }

    public void setRub_price(Double rub_price) {
        this.rub_price = rub_price;
    }

    @Column(name = "rub_price")
    private Double rub_price;

    @Column(name = "date")
    private String date;

    @Column(name="amount")
    @Min(value = 1, message = "Введите положительное целое число")
    private int amount;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }
}
