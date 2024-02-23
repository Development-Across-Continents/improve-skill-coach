package com.improveskillcoach.controllers;

import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.services.SoccerCoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/soccer-coach")
public class SoccerCoachController {

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

}
