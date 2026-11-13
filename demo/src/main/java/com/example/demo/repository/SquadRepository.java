package com.example.demo.repository;

import com.example.demo.model.entities.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepository extends JpaRepository<Squad, Long> {
}