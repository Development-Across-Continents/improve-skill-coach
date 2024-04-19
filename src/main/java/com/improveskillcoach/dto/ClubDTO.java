package com.improveskillcoach.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClubDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @NotBlank(message = "Name must be at least 3 characters")
    @NotNull(message = "The name field is required!")
    private String name;

    @Size(min = 10, message = "description must be at least 10 characters long")
    @NotBlank(message = "description must be at least 10 characters long")
    @NotNull(message = "The description field is required!")
    private String description;

    @Size(min = 2, max = 50, message = "Name of country must be between 2 and 50 characters")
    @NotBlank(message = "The field of country must be in the minimum 3 letters")
    @NotNull(message = "The name field is required!")
    private String country;

    @NotNull(message = "The theYear field is required!")
    @Pattern(regexp ="^\\d{4}-\\d{2}-\\d{2}$", message = "Formato de ano inválido. Use o padrão yyyy-MM-dd.")
    private String foundationYear;

    @NotEmpty(message = "Deve ter pelo menos um SoccerCoach")
    private List<ClubDTO> soccerCoach = new ArrayList<>();

    public ClubDTO(Long id, String name, String description, String country, String foundationYear) {
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
