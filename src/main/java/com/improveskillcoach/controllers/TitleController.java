package com.improveskillcoach.controllers;

import com.improveskillcoach.dto.ClubDTO;
import com.improveskillcoach.dto.TitleDTO;
import com.improveskillcoach.entities.Title;
import com.improveskillcoach.services.TitleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/titles")
public class TitleController {

    @Autowired
    private TitleService service;

    @GetMapping
    public ResponseEntity<Page<TitleDTO>>findAll(
            @RequestParam(name = "name", defaultValue = "")String name,
            Pageable pageable) {
        Page<TitleDTO> dto= service.findAll(name,pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitleDTO> findById(@PathVariable Long id) {
        TitleDTO titleDTO = service.findById(id);
        return ResponseEntity.ok(titleDTO);
    }

    @PostMapping
    public ResponseEntity<TitleDTO> insert(@Valid @RequestBody TitleDTO titleDTO){
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(service.insert(titleDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TitleDTO> update(@PathVariable Long id,@Valid @RequestBody TitleDTO titleDTO){
        titleDTO= service.update(id,titleDTO);
        return ResponseEntity.ok(titleDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

