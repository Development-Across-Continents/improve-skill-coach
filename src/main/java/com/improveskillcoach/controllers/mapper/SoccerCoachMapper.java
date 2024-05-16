package com.improveskillcoach.controllers.mapper;

import com.improveskillcoach.entities.SoccerCoach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SoccerCoachMapper {

    SoccerCoachMapper INSTANCE = Mappers.getMapper(SoccerCoachMapper.class);

    @Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = "yyyy-MM-dd HH:mm:ss")
    SoccerCoach mapJsonToSoccerCoach(SoccerCoach soccerCoach);
}
