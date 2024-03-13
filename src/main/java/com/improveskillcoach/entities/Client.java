package com.improveskillcoach.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name ="tb_client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private LocalDate birthday;


    @ManyToMany(mappedBy = "clients")
    private Set<SoccerCoach> coaches = new HashSet<>();

    public Client(Long id,String name, LocalDate birthday){
        this.id=id;
        this.name= name;
        this.birthday=birthday;
    }
}
