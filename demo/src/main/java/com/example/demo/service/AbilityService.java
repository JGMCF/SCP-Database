package com.example.demo.service;

import com.example.demo.model.entities.Ability;
import com.example.demo.model.entities.AbilityId;
import com.example.demo.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AbilityService extends BaseService<Ability, AbilityId> {

    @Autowired
    private AbilityRepository abilityRepository;

    @Override
    protected JpaRepository<Ability, AbilityId> getRepository() {
        return abilityRepository;
    }
}