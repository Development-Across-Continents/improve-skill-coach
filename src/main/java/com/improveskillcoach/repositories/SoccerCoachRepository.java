package com.improveskillcoach.repositories;

import com.improveskillcoach.entities.SoccerCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SoccerCoachRepository extends JpaRepository<SoccerCoach, Long> {
    @Query("SELECT DISTINCT sc FROM SoccerCoach sc LEFT JOIN FETCH sc.clients WHERE sc.id = :id")
    Optional<SoccerCoach> findByIdWithClients(@Param("id") Long id);
}
