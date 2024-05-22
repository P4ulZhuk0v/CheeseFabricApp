package com.example.Practicheskaya.entity;


import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "materials")
@Data
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

    @Column(name = "date")
    private String date;

    @Column(name="amount")
    private long amount;



    @PrePersist
    public void persist(){
        date = DateParser.getLocalDate();
    }

    public Material(){}

}
