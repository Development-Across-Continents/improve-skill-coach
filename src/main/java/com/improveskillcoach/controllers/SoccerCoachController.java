package com.improveskillcoach.controllers;

import com.improveskillcoach.entities.SoccerCoach;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/soccer-coach")
public class SoccerCoachController {

    @GetMapping
    public ResponseEntity<List<SoccerCoach>> findAll(){
        SoccerCoach soccerCoach = new SoccerCoach(1L, "Name A", LocalDate.now(),"Nationalaty A");

        List soccerCoaches = new ArrayList<SoccerCoach>();

        soccerCoaches.add(soccerCoach);
        return ResponseEntity.ok(soccerCoaches);
    }

    @PostMapping
    public ResponseEntity<SoccerCoach> insert(@RequestBody SoccerCoach soccerCoach){
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(soccerCoach);
    }

}
