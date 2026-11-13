package com.example.demo.service;

import com.example.demo.model.entities.TeamConductsResearch;
import com.example.demo.model.entities.TeamConductsResearchId;
import com.example.demo.repository.TeamConductsResearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamConductsResearchService extends BaseService<TeamConductsResearch, TeamConductsResearchId> {

    private final TeamConductsResearchRepository repository;

    public TeamConductsResearchService(TeamConductsResearchRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<TeamConductsResearch, TeamConductsResearchId> getRepository() {
        return repository;
    }
}