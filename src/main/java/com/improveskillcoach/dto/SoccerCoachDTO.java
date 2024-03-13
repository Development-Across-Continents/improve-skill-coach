package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.entities.Title;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SoccerCoachDTO {

    private Long id;
    private String name;
    private LocalDate birthday;
    private String nationalaty;

    private Club club;
    private Title title;

    @NotEmpty(message = "Deve ter pelo menos um Client")
    private List<ClientDTO> clients = new ArrayList<>();

    public SoccerCoachDTO(Long id, String name, LocalDate birthday, String nationalaty) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.nationalaty = nationalaty;
    }

    public SoccerCoachDTO(SoccerCoach entity) {
        id= entity.getId();
        name= entity.getName();
        birthday=entity.getBirthday();
        nationalaty= entity.getNationalaty();
       /* for(Client clt : entity.getClients()){
            clients.add(new ClientDTO(clt));
        }
    */

    }

}
