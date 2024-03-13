package com.improveskillcoach.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

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


    public Title(Long id, String name, String description, Integer theYear, SoccerCoach soccerCoach) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.theYear = theYear;
        this.soccercoach=soccerCoach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(id, title.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}