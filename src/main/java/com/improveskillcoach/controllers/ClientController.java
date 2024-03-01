package com.improveskillcoach.controllers;

import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.services.ClientService;
import com.improveskillcoach.services.SoccerCoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> clientList = clientService.getAll();
        logger.info("clientList", clientList);
        return ResponseEntity.ok(clientList);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(clientService.insert(client));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(clientService.update(id, client));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
