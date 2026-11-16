package com.example.demo.service;

import com.example.demo.model.entities.SquadMission;
import com.example.demo.model.entities.SquadMissionId;

import com.example.demo.repository.SquadMissionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class SquadMissionService extends BaseService<SquadMission, SquadMissionId> {

    private final SquadMissionRepository squadMissionRepository;

    public SquadMissionService(SquadMissionRepository squadMissionRepository) {
        this.squadMissionRepository = squadMissionRepository;
    }

    @Override
    protected JpaRepository<SquadMission, SquadMissionId> getRepository() {
        return squadMissionRepository;
    }

    @Transactional 
    public SquadMission findSquadMissionRelation(Long squadId, Long missionId){

        SquadMissionId id = new SquadMissionId(squadId, missionId);

        SquadMission relation = squadMissionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Relação entre pesquisa e criatura não encontrada"));
        
        return relation;
    }
        
    @Transactional 
    public void addSquadMissionRelation(Long squadId, Long missionId, Long creatureId){
    
        SquadMission relation = new SquadMission(squadId, missionId, creatureId);
        squadMissionRepository.save(relation);
    }

    @Transactional 
    public void removeSquadMissionRelation(Long squadId, Long missionId){
    
        SquadMission relation = findSquadMissionRelation(squadId, missionId);
        squadMissionRepository.delete(relation);
    }

}