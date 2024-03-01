package com.improveskillcoach.services;

import com.improveskillcoach.controllers.SoccerCoachController;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SoccerCoachService {

    private static final Logger logger = LoggerFactory.getLogger(SoccerCoachService.class);


    @Autowired
    SoccerCoachRepository soccerCoachRepository;

    public List<SoccerCoach> getAll(){

        List soccerCoaches = soccerCoachRepository.findAll();

        return soccerCoaches;
    }

    @Transactional
    public SoccerCoach insert(SoccerCoach soccerCoach){
        soccerCoachRepository.save(soccerCoach);
        return soccerCoach;
    }

    @Transactional
    public SoccerCoach update(Long id, SoccerCoach soccerCoach){

        logger.info(" SoccerCoachService - update - id:", id, " | SoccerCoach:", soccerCoach);

        SoccerCoach soccerCoach1 = soccerCoachRepository.getReferenceById(id);

        logger.info(" SoccerCoachService - update - id:", id, " | SoccerCoach:", soccerCoach1);

        soccerCoach1.setName(soccerCoach.getName());
        soccerCoach1.setBirthday(soccerCoach.getBirthday());
        soccerCoach1.setNationalaty(soccerCoach1.getNationalaty());
        //soccerCoach1.setClients(soccerCoach.getClients());
        //soccerCoach1.setClub(soccerCoach.getClub());
        //soccerCoach1.setTitles(soccerCoach.getTitles());

        soccerCoachRepository.save(soccerCoach1);

        logger.info(" SoccerCoachService - update - saved");

        return soccerCoach1;
    }


    @Transactional
    public void delete(Long id){

        logger.info(" SoccerCoachService - delete - id:", id);

        soccerCoachRepository.deleteById(id);

        logger.info(" SoccerCoachService - deleted");
    }


}
