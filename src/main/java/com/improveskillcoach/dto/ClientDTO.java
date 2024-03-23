package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;



@Setter
@Getter
@NoArgsConstructor

public class ClientDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "The name needs has in the minimum 3 letters and 50 letters in the maximus")
    @NotNull(message = "The name field is required!")
    private String name;

    @Past(message = "The date of birthday must to be in the past")
    @NotNull(message = "The dateOfBirth field is required!")
    private LocalDate dateOfBirth;

    public ClientDTO(Long id, String name, LocalDate dateOfBirth) {
        this.id=id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
    }

    public ClientDTO(Client entity){
        id= entity.getId();
        name= entity.getName();
        dateOfBirth=entity.getDateOfBirth();
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
