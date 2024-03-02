package com.improveskillcoach.controllers;

import com.improveskillcoach.entities.Title;
import com.improveskillcoach.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/titles")
public class TitleController {

    @Autowired
    private TitleService service;

    @GetMapping
    public ResponseEntity<List<Title>>findAll() {
        List<Title> list= service.findAll();
        return ResponseEntity.ok(list);
    }

}
