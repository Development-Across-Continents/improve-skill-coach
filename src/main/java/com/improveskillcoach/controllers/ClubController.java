package com.improveskillcoach.controllers;

import com.improveskillcoach.entities.Club;
import com.improveskillcoach.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/club")
public class ClubController {

@Autowired
private ClubService service;

@GetMapping
    public ResponseEntity<List<Club>> findAll(){
    List<Club> list = service.findALL();
    return ResponseEntity.ok(list);
    }
}


//Comentários para serem apagados:

/*Da linha 21 até à linha 24 começo com uma anotação de GetMapping que é um metodo,
 em que através ResponseEntity vamos obter uma lista de clubes.

 Essa lista de clubes é obtida como ?
 Através da camada service onde tem as regras de negocio vamos chamar a entidade
 club e esta por sua vez é obtida do banco de dados.*/

