package com.improveskillcoach.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.improveskillcoach.dto.SoccerCoachDTO;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.services.ClientService;
import com.improveskillcoach.services.SoccerCoachService;
import jakarta.validation.Valid;
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
    /*
    @GetMapping
    public ResponseEntity<List<SoccerCoach>> findAll(){
        return ResponseEntity.ok(soccerCoachService.getAll());
    }
    */

    @GetMapping
    public ResponseEntity<List<SoccerCoachDTO>> findAllWithRelationship(){
        return ResponseEntity.ok(soccerCoachService.getAllWithRelationship());
    }

    @PostMapping
    public ResponseEntity<SoccerCoachDTO> insert(@RequestBody @Valid SoccerCoachDTO dto){
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(soccerCoachService.insert(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SoccerCoachDTO> update(@PathVariable Long id, @RequestBody @Valid SoccerCoachDTO dto){
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(soccerCoachService.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        soccerCoachService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
