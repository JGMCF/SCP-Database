package com.example.demo.service;

import com.example.demo.model.entities.CreatureAbility;
import com.example.demo.model.entities.CreatureAbilityId;

import com.example.demo.repository.CreatureAbilityRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CreatureAbilityService extends BaseService<CreatureAbility, CreatureAbilityId> {

    private final CreatureAbilityRepository creatureAbilityRepository;

    public CreatureAbilityService(CreatureAbilityRepository creatureAbilityRepository) {
        this.creatureAbilityRepository = creatureAbilityRepository;
    }

    @Override
    protected JpaRepository<CreatureAbility, CreatureAbilityId> getRepository() {
        return creatureAbilityRepository;
    }

    @Transactional 
    public CreatureAbility findCreatureAbilityRelation(Long creatureId, Long abilityId){

        CreatureAbilityId id = new CreatureAbilityId(creatureId, abilityId);

        CreatureAbility relation = creatureAbilityRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Relacao nao encontrada"));
        
        return relation;
    }
        
    @Transactional 
    public void addCreatureAbilityRelation(Long creatureId, Long abilityId){
    
        CreatureAbility relation = new CreatureAbility(creatureId, abilityId);
        creatureAbilityRepository.save(relation);
    }

    @Transactional 
    public void removeCreatureAbilityRelation(Long creatureId, Long abilityId){
    
        CreatureAbility relation = findCreatureAbilityRelation(creatureId, abilityId);
        creatureAbilityRepository.delete(relation);
    }

}