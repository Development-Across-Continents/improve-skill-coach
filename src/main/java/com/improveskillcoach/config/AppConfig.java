package com.improveskillcoach.config;

import com.improveskillcoach.controllers.mapper.SoccerCoachMapper;
import com.improveskillcoach.controllers.mapper.ClientMapper;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.improveskillcoach.controllers.mapper")
public class AppConfig {

    @Bean
    public SoccerCoachMapper soccerCoachMapper() {
        return Mappers.getMapper(SoccerCoachMapper.class);
    }

    @Bean
    public ClientMapper clientMapper() {
        return Mappers.getMapper(ClientMapper.class);
    }

}
