package com.improveskillcoach.services;

import com.improveskillcoach.dto.ClientDTO;
import com.improveskillcoach.dto.ClubDTO;
import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.repositories.ClientRepository;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SoccerCoachRepository soccerCoachRepository;

    @Transactional(readOnly = true)
    public List<Client> getAll(){

        List clients = clientRepository.findAll();
        logger.info("clientList", clients);
        return clients;
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        System.out.println(" ClientService - insert | ClientDTO:"+ dto.toString());
        Client client = new Client();
        copyDtoToEntity(dto, client);
        clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){

        System.out.println(" ClientService - update - id:"+ id + " | ClientDTO:"+ dto.toString());

        Client entity = clientRepository.getReferenceById(id);

        copyDtoToEntity(dto, entity);

        System.out.println(" ClientService - update - id:"+ id +" | Entity:"+ entity);

        clientRepository.save(entity);

        logger.info(" ClientService - update - saved");

        return new ClientDTO(entity);
    }


    @Transactional
    public void delete(Long id){

        logger.info(" ClientService - delete - id:"+ id);

        clientRepository.deleteById(id);

        logger.info(" ClientService - deleted");
    }


    private void copyDtoToEntity(@NotNull ClientDTO dto, @NotNull Client entity){
        entity.setName(dto.getName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setCoaches(entity.getCoaches());
    }


}
