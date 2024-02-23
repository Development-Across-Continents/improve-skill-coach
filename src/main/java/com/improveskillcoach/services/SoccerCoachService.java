package com.improveskillcoach.services;

import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoccerCoachService {

    @Autowired
    SoccerCoachRepository soccerCoachRepository;

    public List<SoccerCoach> getAll(){

        List soccerCoaches = soccerCoachRepository.findAll();

        return soccerCoaches;
    }

    public SoccerCoach insert(SoccerCoach soccerCoach){
        soccerCoachRepository.save(soccerCoach);
        return soccerCoach;
    }


}
