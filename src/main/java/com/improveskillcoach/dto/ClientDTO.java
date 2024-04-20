package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Client;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "The field of message must be in the minimum 3 letters")
    private String name;

    @NotNull(message = "The theYear field is required!")
    @Pattern(regexp ="^\\d{4}-\\d{2}-\\d{2}$", message = "Formato de ano inválido. Use o padrão yyyy-MM-dd.")
    private String dateOfBirth;

    public ClientDTO(Long id, String name, String dateOfBirth) {
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
