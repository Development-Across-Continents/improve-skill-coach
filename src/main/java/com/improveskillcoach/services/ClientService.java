package com.improveskillcoach.services;

import com.improveskillcoach.controllers.mapper.ClientMapper;
import com.improveskillcoach.dto.ClientDTO;
import com.improveskillcoach.dto.SoccerCoachDTO;
import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.repositories.ClientRepository;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import com.improveskillcoach.services.exceptions.BusinessException;
import com.improveskillcoach.services.exceptions.DateTimeParseException;
import com.improveskillcoach.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;

    public List<ClientDTO> getAllWithRelationship(){
        List clients = clientRepository.findAll();

        List<ClientDTO> clientsRelationships = new ArrayList<>();

        for(int i=0; i < clients.size(); i++){

            Client client =  clientMapper.mapJsonToSClient((Client) clients.get(i));

            clientsRelationships.add(new ClientDTO(client, client.getCoaches()));

        }

        return clientsRelationships;
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        System.out.println(" ClientService - insert | ClientDTO:"+ dto.toString());

        LocalDate theYearLocalDate = parseDate(dto.getDateOfBirth());
        verifyIfDateIsInThePresentOrPast(theYearLocalDate);

        Client client = new Client();
        copyDtoToEntity(dto, client);
        clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){

        System.out.println(" ClientService - update - id:"+ id + " | ClientDTO:"+ dto.toString());

        LocalDate theYearLocalDate = parseDate(dto.getDateOfBirth());
        verifyIfDateIsInThePresentOrPast(theYearLocalDate);

        try{
            Client entity = clientRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            System.out.println(" ClientService - update - id:"+ id +" | Entity:"+ entity);
            clientRepository.save(entity);
            logger.info(" ClientService - update - saved");

            return new ClientDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource wasn't found");
        }
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){

        logger.info(" ClientService - delete - id:"+ id);

        Optional<Client> optionalClient = clientRepository.findById(id);

        if(optionalClient.isPresent()){
                clientRepository.deleteById(id);
                logger.info(" ClientService - deleted");
        }else{
            throw new ResourceNotFoundException("Resource wasn't found");
        }
    }


    private void copyDtoToEntity(@NotNull ClientDTO dto, @NotNull Client entity){
        entity.setName(dto.getName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setCoaches(entity.getCoaches());
    }

    private LocalDate parseDate(String date){

        try{
            LocalDate theYear = LocalDate.parse(date);
            return theYear;

        }catch (java.time.format.DateTimeParseException e){
            throw new DateTimeParseException("Unacceptable values from date!");
        }
    }

    private void verifyIfDateIsInThePresentOrPast(LocalDate theYearLocalDate){

        LocalDate localDate = LocalDate.now();

        if(localDate.isBefore(theYearLocalDate)){ //
            throw new BusinessException("The date can't be in the future!");
        }
    }
}
