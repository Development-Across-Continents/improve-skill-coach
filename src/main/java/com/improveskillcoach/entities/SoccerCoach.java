package com.improveskillcoach.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name ="tb_soccer_coaches")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SoccerCoach implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dateOfBirth;
    private String nationalaty;

    @ManyToMany
    @JoinTable(
            name = "coach_client",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients = new ArrayList<>();

    @OneToOne(mappedBy = "coach", cascade = CascadeType.ALL)
    private Club club;

    @OneToMany(mappedBy = "soccercoach")
    private List<Title> titles = new ArrayList<>();


    public SoccerCoach(Long id, String name, String dateOfBirth, String nationalaty){
        this.id=id;
        this.name= name;
        this.dateOfBirth=dateOfBirth;
        this.nationalaty=nationalaty;
    }

}
