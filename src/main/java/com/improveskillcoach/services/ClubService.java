package com.improveskillcoach.services;


import com.improveskillcoach.dto.ClubDTO;
import com.improveskillcoach.dto.SoccerCoachDTO;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.repositories.ClubRepository;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import com.improveskillcoach.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private SoccerCoachRepository soccerCoachRepository;

    @Transactional(readOnly= true)
    public ClubDTO findById(Long id){
        Club club= clubRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClubDTO(club);
    }

    @Transactional
    public ClubDTO insert(ClubDTO dto){
        Club club= new Club();


       club.setName(dto.getName());
       club.setFoundationYear(dto.getFoundationYear());
       club.setCountry(dto.getCountry());
       club.setDescription(dto.getDescription());

       clubRepository.save(club);
       return new ClubDTO(club);

      // o retorno desta função é apenas para mostrar os dados que foram salvos no banco de dados, por exemplo através do Postman

    }

    /*
    public ClubDTO update(Long id, ClubDTO clubDTO) {

    }
*/

}
