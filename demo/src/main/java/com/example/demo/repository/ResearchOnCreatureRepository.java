package com.example.demo.repository;

import com.example.demo.model.entities.ResearchOnCreature;
import com.example.demo.model.entities.ResearchOnCreatureId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchOnCreatureRepository extends JpaRepository<ResearchOnCreature, ResearchOnCreatureId> {
}