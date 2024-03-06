package com.improveskillcoach.controllers;

import com.improveskillcoach.dto.ClubDTO;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping
    public ResponseEntity<ClubDTO> insert(@RequestBody ClubDTO clubDTO) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(clubService.insert(clubDTO));
    }

}

    /*
    @PutMapping("/{id}")
public ResponseEntity<ClubDTO> update(@PathVariable Long id, @RequestBody ClubDTO clubDTO){
    ClubDTO updateClubDTO = clubService.update(id, clubDTO);
    return ResponseEntity.ok(updateClubDTO);
    }
}

@GetMapping
    public ResponseEntity<List<Club>> findAll(){
    List<Club> list = service.findALL();
    return ResponseEntity.ok(list);
    }
}
*/

//Comentários para serem apagados:

/*Da linha 21 até à linha 24 começo com uma anotação de GetMapping que é um metodo,
 em que através ResponseEntity vamos obter uma lista de clubes.

 Essa lista de clubes é obtida como ?
 Através da camada service onde tem as regras de negocio vamos chamar a entidade
 club e esta por sua vez é obtida do banco de dados.*/

