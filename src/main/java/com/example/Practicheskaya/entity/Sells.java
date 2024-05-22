package com.example.Practicheskaya.entity;

import com.example.Practicheskaya.utills.DateParser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="sells")
@Data
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
}
