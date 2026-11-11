package com.example.demo.repository;

import com.example.demo.model.entities.TeamConductsResearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamConductsResearchRepository extends JpaRepository<TeamConductsResearch, Long> {
}