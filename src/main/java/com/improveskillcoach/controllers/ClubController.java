package com.improveskillcoach.controllers;

import com.improveskillcoach.dto.ClubDTO;
import com.improveskillcoach.dto.TitleDTO;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/{id}")
    public ResponseEntity<ClubDTO> findById(@PathVariable Long id) {
        ClubDTO clubDTO = clubService.findById(id);
        return ResponseEntity.ok(clubDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ClubDTO>>findAll(
            @RequestParam(name = "name", defaultValue = "")String name,
            Pageable pageable) {
        Page<ClubDTO> dto= clubService.findAll(name,pageable);
        return ResponseEntity.ok(dto);
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<ClubDTO> update(@PathVariable Long id,@Valid @RequestBody ClubDTO clubDTO){
        clubDTO = clubService.update(id, clubDTO);
        return ResponseEntity.ok(clubDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clubService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ClubDTO> insert(@RequestBody @Valid ClubDTO clubDTO){
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(clubService.insert(clubDTO));
    }


}





