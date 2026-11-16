package com.example.demo.service;

import com.example.demo.model.entities.Creature;
import com.example.demo.model.enums.CreatureClass;
import com.example.demo.model.enums.CreatureType;
import com.example.demo.repository.CreatureRepository;
import com.example.demo.repository.SiteRepository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatureService extends BaseService<Creature, Long> {

    private final CreatureRepository creatureRepository;

    public CreatureService(CreatureRepository creatureRepository, SiteRepository siteRepository) {
        this.creatureRepository = creatureRepository;
    }

    @Override
    protected JpaRepository<Creature, Long> getRepository() {
        return creatureRepository;
    }

     @Transactional 
    public Creature findCreature(Long creatureId) {

        Creature creature = creatureRepository.findById(creatureId)
            .orElseThrow(() -> new RuntimeException("Criatura nao encontrada"));

        return creature;
    }

    @Transactional 
    public void changeCreatureCodename(Long creatureId, String newCodename) {

        Creature creature = findCreature(creatureId);

        creature.setCreatureCodename(newCodename);
        creatureRepository.save(creature);
    }

    @Transactional
    public void changeContainedIn(Long creatureId, Long siteId) {

        Creature creature = findCreature(creatureId);

        creature.setContainedIn(siteId);
        creatureRepository.save(creature);
    }

    @Transactional
    public void changeCreatureType(Long creatureId, CreatureType newType) {

        Creature creature = findCreature(creatureId);

        creature.setCreatureType(newType);
        creatureRepository.save(creature);
    }

    @Transactional
    public void changeAggressivenessLevel(Long creatureId, Integer newLevel) {

        Creature creature = findCreature(creatureId);

        creature.setAggressivenessLevel(newLevel);
        creatureRepository.save(creature);
    }

    @Transactional
    public void changeCreatureClass(Long creatureId, CreatureClass newClass) {

        Creature creature = findCreature(creatureId);

        creature.setCreatureClass(newClass);
        creatureRepository.save(creature);
    }

    @Transactional
    public void changeName(Long creatureId, int newNumberCode) {

        Creature creature = findCreature(creatureId);

        creature.setNumberCode(newNumberCode);
        creatureRepository.save(creature);
    }

    @Transactional
    public void changeDescription(Long creatureId, String newDescription) {

        Creature creature = findCreature(creatureId);
        
        creature.setDescription(newDescription);
        creatureRepository.save(creature);
    }
}