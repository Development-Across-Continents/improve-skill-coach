package com.improveskillcoach.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name= "tb_titles")
public class Title implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer theYear;

    @ManyToOne
    @JoinColumn(name = "soccer_coach_id")
    private SoccerCoach soccercoach;


    public Title(Long id, String name, String description, Integer theYear) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.theYear = theYear;
    }

}