package com.example.demo.service;

import com.example.demo.model.entities.Ability;
import com.example.demo.model.entities.AbilityId;
import com.example.demo.model.enums.CreatureType;

import com.example.demo.repository.AbilityRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Ability findAbility(Long creatureId, Long abilityId) {

        AbilityId id = new AbilityId(creatureId, abilityId);

        return abilityRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Habilidade nao encontrada para esta criatura"));
    }

    @Transactional
    public void changeName(Long creatureId, Long abilityId, String newName) {

        Ability ability = findAbility(creatureId, abilityId);

        ability.setName(newName);
        abilityRepository.save(ability);
    }

    @Transactional
    public void changeDescription(Long creatureId, Long abilityId, String newDescription) {

        Ability ability = findAbility(creatureId, abilityId);

        ability.setDescription(newDescription);
        abilityRepository.save(ability);
    }

    @Transactional
    public void changeFrequency(Long creatureId, Long abilityId, Integer newFrequency) {

        Ability ability = findAbility(creatureId, abilityId);

        ability.setFrequency(newFrequency);
        abilityRepository.save(ability);
    }

    @Transactional
    public void changeAbilityType(Long creatureId, Long abilityId, CreatureType newAbilityType) {
        
        Ability ability = findAbility(creatureId, abilityId);

        ability.setAbilityType(newAbilityType);
        abilityRepository.save(ability);
    }
}