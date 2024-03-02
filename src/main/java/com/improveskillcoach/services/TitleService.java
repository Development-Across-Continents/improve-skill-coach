package com.improveskillcoach.services;

import com.improveskillcoach.entities.Title;
import com.improveskillcoach.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TitleService {

    @Autowired
    private TitleRepository repository;

    @Transactional(readOnly = true)
    public List<Title> findAll(){
        List<Title> result = repository.findAll();
        return result;
    }
}


