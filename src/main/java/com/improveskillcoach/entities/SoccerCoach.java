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
@Table(name ="tb_soccer_coaches")
public class SoccerCoach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthday;

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


    public SoccerCoach(Long id, String name, LocalDate birthday, String nationalaty){
    this.id=id;
    this.name= name;
    this.birthday=birthday;
    this.nationalaty=nationalaty;
    }


}
