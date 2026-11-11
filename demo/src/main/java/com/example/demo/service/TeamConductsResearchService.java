package com.example.demo.service;

import com.example.demo.model.entities.TeamConductsResearch;
import com.example.demo.model.entities.TeamConductsResearchId;
import com.example.demo.repository.TeamConductsResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamConductsResearchService extends BaseService<TeamConductsResearch, TeamConductsResearchId> {

    @Autowired
    private TeamConductsResearchRepository repository;

    @Override
    protected JpaRepository<TeamConductsResearch, TeamConductsResearchId> getRepository() {
        return repository;
    }
}