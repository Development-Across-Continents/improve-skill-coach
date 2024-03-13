package com.improveskillcoach.repositories;

import com.improveskillcoach.dto.ClubDTO;
import com.improveskillcoach.entities.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Page<Club> searchByName(String name, Pageable pageable);
}
