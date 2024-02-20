package com.improveskillcoach.repositories;

import com.improveskillcoach.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
