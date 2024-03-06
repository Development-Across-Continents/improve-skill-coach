package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Title;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitleDTO {

    private Long id;
    private String name;
    private String description;
    private Integer theYear;

    private SoccerCoachDTO soccerCoachDto;

    public TitleDTO(Long id, String name, String description, Integer theYear, SoccerCoachDTO soccerCoachDto){
        this.id= id;
        this.name= name;
        this.description= description;
        this.theYear= theYear;
    }

    public TitleDTO(Title entity){
        this.id= entity.getId();
        this.name=entity.getName();
        this.description= entity.getDescription();
        this.theYear= entity.getTheYear();
        this.soccerCoachDto= new SoccerCoachDTO(entity.getSoccercoach());
    }
}
