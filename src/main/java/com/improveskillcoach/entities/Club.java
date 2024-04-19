package com.improveskillcoach.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "tb_club")
public class Club implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String country;
    private String foundationYear;


    @OneToOne
    @JoinColumn(name = "coach_id")
    private SoccerCoach coach;

    public Club (Long id,String name, String description, String country, String foundationYear){
        this.id=id;
        this.name=name;
        this.description=description;
        this.country=country;
        this.foundationYear=foundationYear;

    }

}
