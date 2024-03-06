package com.improveskillcoach.services;

import com.improveskillcoach.repositories.ClubRepository;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SoccerCoachService {

    @Autowired
    private SoccerCoachRepository soccerCoachRepository;

    @Autowired
    private ClubRepository clubRepository;
}
