package com.improveskillcoach.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name ="tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    private LocalDate birthday;


    @ManyToMany(mappedBy = "clients")
    private List<SoccerCoach> coaches = new ArrayList<>();

    public Client(String name, LocalDate birthday){
        this.name= name;
    }
}
