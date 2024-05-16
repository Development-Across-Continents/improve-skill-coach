package com.improveskillcoach.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.improveskillcoach.entities.Title;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class TitleDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "The name needs has in the minimum 3 letters and 50 letters in the maximus")
    @NotNull(message = "The name field is required!")
    @NotBlank(message = "The field of name must be in the minimum 3 letters")
    private String name;

    @Size(min = 3, max = 50, message = " The description needs has in the minimum 3 letters and 50 letters in the maximums")
    @NotBlank(message = "The field of message must be in the minimum 3 letters")
    @NotNull(message = "The name field is required!")
    private String description;


    @NotNull(message = "The theYear field is required!")
    @Pattern(regexp ="^\\d{4}-\\d{2}-\\d{2}$", message = "Formato de ano inválido. Use o padrão yyyy-MM-dd.")
    private String theYear;

    private SoccerCoachDTO soccerCoach;

    public TitleDTO(Long id, String name, String description, String theYear){
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


    }
}
