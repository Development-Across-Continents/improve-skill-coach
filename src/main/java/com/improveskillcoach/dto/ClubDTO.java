package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClubDTO {

    private Long id;
    private String name;
    private String description;
    private String country;
    private Integer foundationYear;

    @NotEmpty(message = "Deve ter pelo menos um SoccerCoach")
    private List<ClubDTO> soccerCoach = new ArrayList<>();

    public ClubDTO(Long id, String name, String description, String country, Integer foundationYear) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.foundationYear = foundationYear;
    }

  public ClubDTO(Club entity){
        id= entity.getId();
        name= entity.getName();
        description= entity.getDescription();
        country= entity.getCountry();
        foundationYear= entity.getFoundationYear();
  }


}
