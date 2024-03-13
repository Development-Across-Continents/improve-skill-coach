package com.improveskillcoach.dto;

import com.improveskillcoach.entities.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor

public class ClientDTO {

    private Long id;
    private String name;

    private LocalDate birthday;


    public ClientDTO(Long id, String name, LocalDate birthday) {
        this.id=id;
        this.name=name;
        this.birthday=birthday;
    }

    public ClientDTO(Client entity){
        id= entity.getId();
        name= entity.getName();
        birthday=entity.getBirthday();
    }
}
