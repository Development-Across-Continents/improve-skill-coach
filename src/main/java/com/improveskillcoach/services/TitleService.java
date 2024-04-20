package com.improveskillcoach.services;

import com.improveskillcoach.dto.TitleDTO;

import com.improveskillcoach.entities.Title;
import com.improveskillcoach.repositories.TitleRepository;
import com.improveskillcoach.services.exceptions.BusinessException;
import com.improveskillcoach.services.exceptions.DatabaseException;
import com.improveskillcoach.services.exceptions.DateTimeParseException;
import com.improveskillcoach.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;



@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    //@Autowired
    //private SoccerCoachRepository soccerCoachRepository;

    @Transactional(readOnly = true) //METODO FINDALL
    public Page<TitleDTO> findAll(String name, Pageable pageable){
        //soccerCoachRepository.findAll();
        Page<Title> result= titleRepository.searchByName(name,pageable);
        return result.map(x-> new TitleDTO(x));
    }

    @Transactional(readOnly = true) //METODO FINDBYID
    public TitleDTO findById(@PathVariable Long id){
        Title title = titleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
                return new TitleDTO(title);

    }

    @Transactional //METODO INSERT
    public TitleDTO insert(TitleDTO titleDTO){

        LocalDate theYearLocalDate = parseDate(titleDTO.getTheYear());
        verifyDate(theYearLocalDate);

        Title title= new Title();
        copyDtoToEntity(titleDTO, title);

        titleRepository.save(title);
        return new TitleDTO(title); //O controller recebe o retorno do metodo
    }

    @Transactional //METODO UPDATE
    public TitleDTO update(Long id,TitleDTO titleDTO){

        LocalDate theYearLocalDate = parseDate(titleDTO.getTheYear());
        verifyDate(theYearLocalDate);

        try{
            Title entity= titleRepository.getReferenceById(id);
            copyDtoToEntity(titleDTO,entity);

            entity= titleRepository.save(entity);
            return new TitleDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional //METODO DELETE
    public void delete(Long id){
        try{
            titleRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(TitleDTO titleDTO, Title entity){
        entity.setDescription(titleDTO.getDescription());
        entity.setName(titleDTO.getName());
       // entity.setSoccercoach(titleDTO.getSoccerCoachDto());
        entity.setTheYear(titleDTO.getTheYear());
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


