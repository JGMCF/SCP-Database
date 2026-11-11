package com.example.demo.repository;

import com.example.demo.model.entities.ResearchOnCreature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchOnCreatureRepository extends JpaRepository<ResearchOnCreature, Long> {
}