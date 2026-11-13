package com.example.demo.repository;

import com.example.demo.model.entities.TeamConductsResearch;
import com.example.demo.model.entities.TeamConductsResearchId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamConductsResearchRepository extends JpaRepository<TeamConductsResearch, TeamConductsResearchId> {
}