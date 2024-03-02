package com.improveskillcoach.services;

import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.repositories.ClientRepository;
import com.improveskillcoach.repositories.SoccerCoachRepository;
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
    public Client insert(Client client){
        clientRepository.save(client);
        return client;
    }

    @Transactional
    public Client update(Long id, Client client){

        logger.info(" ClientService - update - id:", id, " | ClientService:", client);

        Client client1 = clientRepository.getReferenceById(id);

        logger.info(" SoccerCoachService - update - id:", id, " | SoccerCoach:", client1);

        client1.setName(client.getName());
        client1.setBirthday(client.getBirthday());

        clientRepository.save(client1);

        logger.info(" ClientService - update - saved");

        return client1;
    }


    @Transactional
    public void delete(Long id){

        logger.info(" ClientService - delete - id:", id);

        clientRepository.deleteById(id);

        logger.info(" ClientService - deleted");
    }


}
