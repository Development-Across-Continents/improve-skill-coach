package com.improveskillcoach.controllers;

import com.improveskillcoach.dto.TitleDTO;
import com.improveskillcoach.entities.Title;
import com.improveskillcoach.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<TitleDTO>>findAll(Pageable pageable) {
        Page<TitleDTO> list= service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

}
