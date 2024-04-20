package com.improveskillcoach.services;

import com.improveskillcoach.controllers.SoccerCoachController;
import com.improveskillcoach.dto.ClientDTO;
import com.improveskillcoach.dto.SoccerCoachDTO;
import com.improveskillcoach.entities.Client;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import com.improveskillcoach.services.exceptions.BusinessException;
import com.improveskillcoach.services.exceptions.DateTimeParseException;
import com.improveskillcoach.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    public SoccerCoachDTO insert(SoccerCoachDTO dto){
        System.out.println(" SoccerCoachService - insert | SoccerCoach:"+ dto.toString());

        LocalDate theYearLocalDate = parseDate(dto.getDateOfBirth());
        verifyDate(theYearLocalDate);

        SoccerCoach entity = new SoccerCoach();
        copyDtoToEntity(dto, entity);

        soccerCoachRepository.save(entity);
        return new SoccerCoachDTO(entity);
    }

    @Transactional
    public SoccerCoachDTO update(Long id, SoccerCoachDTO dto){

        System.out.println(" SoccerCoachService - update - id:"+ id +" | SoccerCoach:"+ dto.toString());

        LocalDate theYearLocalDate = parseDate(dto.getDateOfBirth());
        verifyDate(theYearLocalDate);

        try{
            SoccerCoach entity = soccerCoachRepository.getReferenceById(id);

            copyDtoToEntity(dto, entity);
            soccerCoachRepository.save(entity);
            System.out.println(" SoccerCoachService - update - saved");
            return new SoccerCoachDTO(entity);

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource wasn't found");
        }
    }


    @Transactional
    public void delete(Long id){

        System.out.println(" SoccerCoachService - delete - id:"+ id);

        Optional<SoccerCoach> optionalSoccerCoach = soccerCoachRepository.findById(id);

        if(optionalSoccerCoach.isPresent()){
            soccerCoachRepository.deleteById(id);
            logger.info(" SoccerCoachService - deleted");
        }else{
            throw new ResourceNotFoundException("Resource wasn't found");
        }
    }


    private void copyDtoToEntity(@NotNull SoccerCoachDTO dto, @NotNull SoccerCoach entity){
        entity.setName(dto.getName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setNationalaty(dto.getNationalaty());
    }

    private LocalDate parseDate(String date){

        try{
            LocalDate localDate = LocalDate.now();
            LocalDate theYear = LocalDate.parse(date);
            return theYear;

        }catch (java.time.format.DateTimeParseException e){
            throw new DateTimeParseException("Unacceptable values from date!");
        }
    }

    private void verifyDate(LocalDate theYearLocalDate){

        LocalDate localDate = LocalDate.now();

        if(localDate.isBefore(theYearLocalDate)){ //
            throw new BusinessException("The date can't be in the future!");
        }
    }
}
