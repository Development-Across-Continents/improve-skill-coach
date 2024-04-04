package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.entities.Title;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SoccerCoachDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "The name needs has in the minimum 3 letters and 50 letters in the maximus")
    @NotNull(message = "The name field is required!")
    @NotBlank(message = "The field of message must be in the minimum 3 letters")
    private String name;

    @Past(message = "The date of birthday must to be in the past")
    @NotNull(message = "The dateOfBirth field is required!")
    private LocalDate dateOfBirth;

    @Size(min = 2, max = 30, message = "The nationality needs has in the minimum 2 letters and 30 letters in the maximus")
    @NotBlank(message = "The field of message must be in the minimum 2 letters")
    private String nationalaty;

    private Club club;
    private Title title;

    private List<ClientDTO> clients = new ArrayList<>();

    public SoccerCoachDTO(Long id, String name, LocalDate dateOfBirth, String nationalaty) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationalaty = nationalaty;
    }

    public SoccerCoachDTO(SoccerCoach entity) {
        id= entity.getId();
        name= entity.getName();
        dateOfBirth=entity.getDateOfBirth();
        nationalaty= entity.getNationalaty();
       /* for(Client clt : entity.getClients()){
            clients.add(new ClientDTO(clt));
        }
    */

    }

    @Override
    public String toString() {
        return "SoccerCoachDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationalaty='" + nationalaty + '\'' +
                ", club=" + club +
                ", title=" + title +
                ", clients=" + clients +
                '}';
    }
}
