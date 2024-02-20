package com.improveskillcoach.repositories;

import com.improveskillcoach.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
