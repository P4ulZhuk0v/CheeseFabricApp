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
    @Pattern(regexp = "[а-яА-Я ]+", message = "Имя не дожно содержать символов кроме русских букв и пробелов")
    private String cheeseName;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    @Min(value = 1, message = "Введите положительное целое число")
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

    public Long getId() {
        return id;
    }
}
