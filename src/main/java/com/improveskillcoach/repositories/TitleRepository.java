package com.improveskillcoach.repositories;

import com.improveskillcoach.entities.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, Long> {

    Page<Title> searchByName(String name, Pageable pageable);
}
