package com.example.demo.service;

import com.example.demo.model.entities.ResearchOnCreature;
import com.example.demo.model.entities.ResearchOnCreatureId;
import com.example.demo.repository.ResearchOnCreatureRepository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResearchOnCreatureService extends BaseService<ResearchOnCreature, ResearchOnCreatureId> {

    private final ResearchOnCreatureRepository researchOnCreatureRepo;


    public ResearchOnCreatureService(ResearchOnCreatureRepository ResearchOnCreatureRepository) {
        this.researchOnCreatureRepo = ResearchOnCreatureRepository;
    }

    @Override
    protected JpaRepository<ResearchOnCreature, ResearchOnCreatureId> getRepository() {
        return researchOnCreatureRepo;
    }


    @Transactional 
    public ResearchOnCreature findCreatureResearchRelation(Long creatureId, Long researchId){

        ResearchOnCreatureId id = new ResearchOnCreatureId(researchId, creatureId);

        ResearchOnCreature relation = researchOnCreatureRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Relação entre pesquisa e criatura não encontrada"));
        
        return relation;
    }
        

    @Transactional 
    public void addCreatureResearchRelation(Long creatureId, Long researchId){

        ResearchOnCreature relation = new ResearchOnCreature(researchId, creatureId);
        researchOnCreatureRepo.save(relation);
    }

    @Transactional 
    public void removeCreaturaResearchRelation(Long creatureId, Long researchId){
    
        ResearchOnCreature relation = findCreatureResearchRelation(creatureId, researchId);
        researchOnCreatureRepo.delete(relation);
    }

   

}