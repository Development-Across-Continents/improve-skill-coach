package com.improveskillcoach.controllers.mapper;

import com.improveskillcoach.entities.SoccerCoach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "yyyy-MM-dd HH:mm:ss")
    SoccerCoach mapJsonToSoccerCoach(SoccerCoach soccerCoach);
}
