package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Title;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TitleDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @NotBlank(message = "required field")
    @NonNull // @NotNull
    private String name;

    @Size(min = 3, message = "description must be at least 3 characters long")
    @NotBlank(message = "required field")
    @NonNull // @NotNull
    private String description;

    @NotBlank(message = "required field")
    @NonNull // @NotNull
    @PastOrPresent
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
       // this.soccerCoachDto= new SoccerCoachDTO(entity.getSoccercoach());
    }
}
