package com.example.demo.repository;

import com.example.demo.model.entities.ResearchTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchTeamRepository extends JpaRepository<ResearchTeam, Long> {
}