package com.improveskillcoach.services;


import com.improveskillcoach.entities.Club;
import com.improveskillcoach.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private ClubRepository repository;

    @Transactional(readOnly= true)
    public List<Club>findALL(){
        List<Club> result= repository.findAll();
        return result;
    }


}
