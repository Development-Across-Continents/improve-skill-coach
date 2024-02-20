package com.improveskillcoach.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "tb_club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String country;
    private Year foundationYear;


    @OneToOne
    @JoinColumn(name = "coach_id")
    private SoccerCoach coach;

    public Club (Long id,String name, String description, String country, Year foundationYear){
        this.id=id;
        this.name=name;
        this.description=description;
        this.country=country;
        this.foundationYear=foundationYear;

    }

}
