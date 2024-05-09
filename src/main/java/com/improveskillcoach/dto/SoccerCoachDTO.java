package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.entities.Title;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "The theYear field is required!")
    @Pattern(regexp ="^\\d{4}-\\d{2}-\\d{2}$", message = "Formato de ano inválido. Use o padrão yyyy-MM-dd.")
    private String dateOfBirth;

    @Size(min = 2, max = 30, message = "The nationality needs has in the minimum 2 letters and 30 letters in the maximus")
    @NotBlank(message = "The field of message must be in the minimum 2 letters")
    @NotNull(message = "The nationalaty field is required!")
    private String nationalaty;

    private ClubDTO club;

    private List<TitleDTO> titles = new ArrayList<>();

    private List<ClientDTO> clients = new ArrayList<>();

    public SoccerCoachDTO(){

    }

    public SoccerCoachDTO(Long id, String name, String dateOfBirth, String nationalaty) {
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
    }

    public SoccerCoachDTO(SoccerCoach entity, Club club, List<Client> clientList, List<Title> titleList) {
        id= entity.getId();
        name= entity.getName();
        dateOfBirth=entity.getDateOfBirth();
        nationalaty= entity.getNationalaty();

        for(Client client : clientList){
            clients.add(new ClientDTO(client));
        }

        for(Title title : titleList){
            titles.add(new TitleDTO(title));
        }

        this.club = new ClubDTO(club);
    }

    @Override
    public String toString() {
        return "SoccerCoachDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationalaty='" + nationalaty + '\'' +
                ", club=" + club +
                ", title=" + titles +
                ", clients=" + clients +
                '}';
    }
}
