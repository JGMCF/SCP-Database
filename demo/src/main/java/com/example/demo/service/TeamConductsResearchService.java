package com.example.demo.service;

import com.example.demo.model.entities.TeamConductsResearch;
import com.example.demo.model.entities.TeamConductsResearchId;

import com.example.demo.repository.TeamConductsResearchRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class TeamConductsResearchService extends BaseService<TeamConductsResearch, TeamConductsResearchId> {

    private final TeamConductsResearchRepository teamResearchRepository;

    public TeamConductsResearchService(TeamConductsResearchRepository teamResearchRepository) {
        this.teamResearchRepository = teamResearchRepository;
    }

    @Override
    protected JpaRepository<TeamConductsResearch, TeamConductsResearchId> getRepository() {
        return teamResearchRepository;
    }

    @Transactional 
    public TeamConductsResearch findTeamResearchRelation(Long teamId, Long researchId){

        TeamConductsResearchId id = new TeamConductsResearchId(researchId, teamId);

        TeamConductsResearch relation = teamResearchRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Relacao nao encontrada"));
        
        return relation;
    }
        
    @Transactional 
    public void addTeamResearchRelation(Long teamId, Long researchId){
    
        TeamConductsResearch relation = new TeamConductsResearch(teamId, researchId);
        teamResearchRepository.save(relation);
    }

    @Transactional 
    public void removeTeamResearchRelation(Long teamId, Long researchId){
    
        TeamConductsResearch relation = findTeamResearchRelation(teamId, researchId);
        teamResearchRepository.delete(relation);
    }

}