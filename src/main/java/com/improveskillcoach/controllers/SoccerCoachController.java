package com.improveskillcoach.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.services.ClientService;
import com.improveskillcoach.services.SoccerCoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/soccer-coach")
public class SoccerCoachController {
    private static final Logger logger = LoggerFactory.getLogger(SoccerCoachController.class);

    @Autowired
    SoccerCoachService soccerCoachService;

    @GetMapping
    public ResponseEntity<List<SoccerCoach>> findAll(){
        return ResponseEntity.ok(soccerCoachService.getAll());
    }

    @PostMapping
    public ResponseEntity<SoccerCoach> insert(@RequestBody SoccerCoach soccerCoach){
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(soccerCoachService.insert(soccerCoach));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SoccerCoach> update(@PathVariable Long id, @RequestBody SoccerCoach soccerCoach){
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(soccerCoachService.update(id, soccerCoach));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SoccerCoach> update(@PathVariable Long id){
        soccerCoachService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
