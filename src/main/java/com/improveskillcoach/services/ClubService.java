package com.improveskillcoach.services;


import com.improveskillcoach.dto.ClubDTO;
import com.improveskillcoach.dto.SoccerCoachDTO;
import com.improveskillcoach.dto.TitleDTO;
import com.improveskillcoach.entities.Club;
import com.improveskillcoach.entities.SoccerCoach;
import com.improveskillcoach.entities.Title;
import com.improveskillcoach.repositories.ClubRepository;
import com.improveskillcoach.repositories.SoccerCoachRepository;
import com.improveskillcoach.services.exceptions.BusinessException;
import com.improveskillcoach.services.exceptions.DatabaseException;
import com.improveskillcoach.services.exceptions.DateTimeParseException;
import com.improveskillcoach.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private SoccerCoachRepository soccerCoachRepository;

    @Transactional(readOnly = true) //METODO FINDALL
    public Page<ClubDTO> findAll(String name, Pageable pageable){
        //soccerCoachRepository.findAll();
        Page<Club> result= clubRepository.searchByName(name,pageable);
        return result.map(x-> new ClubDTO(x));
    }

    @Transactional(readOnly= true)
    public ClubDTO findById(Long id){
        Club club= clubRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClubDTO(club);
    }

    @Transactional
    public ClubDTO insert(ClubDTO dto){

        LocalDate theYearLocalDate = parseDate(dto.getFoundationYear());
        verifyDate(theYearLocalDate);

        Club club = new Club();
        copyDtoToEntity(dto, club);
       clubRepository.save(club);
       return new ClubDTO(club);

      // o retorno desta função é apenas para mostrar os dados que foram salvos no banco de dados, por exemplo através do Postman

    }

    @Transactional
    public ClubDTO update(Long id, ClubDTO clubDTO) {

        LocalDate theYearLocalDate = parseDate(clubDTO.getFoundationYear());
        verifyDate(theYearLocalDate);

        try{
            Club entity= clubRepository.getReferenceById(id);
            copyDtoToEntity(clubDTO,entity);
            entity= clubRepository.save(entity); //esses valores são salvos no banco, vai atualizar esses dados que vêm do ClubDTO e depois de serem salvos estão prontos para fazer um get deles.
            return new ClubDTO(entity); // Aqui o retorno do ClubDTO é apenas para mostrar os dados que foram salvos no banco de dados, por exemplo através do Postman?
        }
          catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
          }
    }

    @Transactional
    public void delete(Long id){
        try{
            clubRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado"); //quando não existe cadastro
        }
        catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial"); // quando tenta deletar algo que tem uma relação com outro objeto
        }
    }

    private void copyDtoToEntity(@NotNull ClubDTO dto, @NotNull Club entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCountry(dto.getCountry());
        entity.setFoundationYear(dto.getFoundationYear());
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

