package com.example.demo.service;

import com.example.demo.model.entities.Creature;
import com.example.demo.repository.CreatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatureService extends BaseService<Creature, Long> {

    private final CreatureRepository creatureRepository;

    public CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    @Override
    protected JpaRepository<Creature, Long> getRepository() {
        return creatureRepository;
    }
}