package com.example.demo.service;

import com.example.demo.model.entities.Ability;
import com.example.demo.model.entities.AbilityId;
import com.example.demo.repository.AbilityRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AbilityService extends BaseService<Ability, AbilityId> {

    private final AbilityRepository abilityRepository;

    public AbilityService(AbilityRepository abilityRepository) {
    this.abilityRepository = abilityRepository;
}

    @Override
    protected JpaRepository<Ability, AbilityId> getRepository() {
        return abilityRepository;
    }
}