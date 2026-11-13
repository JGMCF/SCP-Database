package com.example.demo.service;

import com.example.demo.model.entities.ResearchOnCreature;
import com.example.demo.model.entities.ResearchOnCreatureId;
import com.example.demo.repository.ResearchOnCreatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResearchOnCreatureService extends BaseService<ResearchOnCreature, ResearchOnCreatureId> {

    private final ResearchOnCreatureRepository repository;

    public ResearchOnCreatureService(ResearchOnCreatureRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<ResearchOnCreature, ResearchOnCreatureId> getRepository() {
        return repository;
    }
}