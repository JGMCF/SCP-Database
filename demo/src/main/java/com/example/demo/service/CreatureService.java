package com.example.demo.service;

import com.example.demo.model.entities.Creature;
import com.example.demo.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatureService extends BaseService<Creature, Long> {

    @Autowired
    private CreatureRepository creatureRepository;

    @Override
    protected JpaRepository<Creature, Long> getRepository() {
        return creatureRepository;
    }
}