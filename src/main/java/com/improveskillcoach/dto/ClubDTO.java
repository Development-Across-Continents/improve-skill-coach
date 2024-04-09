package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClubDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @NotBlank(message = "required field")
    @NonNull
    private String name;

    @Size(min = 10, message = "description must be at least 10 characters long")
    @NotBlank(message = "required field")
    @NonNull
    private String description;

    @Size(min = 3, max = 50, message = "Name of country must be between 2 and 50 characters")
    @NotBlank(message = "required field")
    @NonNull
    private String country;

    @NotBlank(message = "required field")
    @NonNull
    @PastOrPresent
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
