package com.improveskillcoach.dto;

import com.improveskillcoach.entities.SoccerCoach;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SoccerCoachDTO {

    private Long id;
    private String name;
    private LocalDate birthday;
    private String nationalaty;

    public SoccerCoachDTO(Long id, String name, LocalDate birthday, String nationalaty) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.nationalaty = nationalaty;
    }

    public SoccerCoachDTO(SoccerCoach entity) {
        id= entity.getId();
        name= entity.getName();
        birthday=entity.getBirthday();
        nationalaty= entity.getNationalaty();
    }

}
