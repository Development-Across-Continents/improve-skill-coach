package com.improveskillcoach.services;

import com.improveskillcoach.dto.TitleDTO;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.entities.Title;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import com.improveskillcoach.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private SoccerCoachRepository soccerCoachRepository;

    @Transactional(readOnly = true)
    public Page<TitleDTO> findAll(Pageable pageable){
        soccerCoachRepository.findAll();
        Page<Title> result= titleRepository.findAll(pageable);
        return result.map((x-> new TitleDTO(x)));
    }
}


