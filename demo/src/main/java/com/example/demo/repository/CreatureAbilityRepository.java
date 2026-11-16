package com.example.demo.repository;

import com.example.demo.model.entities.CreatureAbility;
import com.example.demo.model.entities.CreatureAbilityId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatureAbilityRepository extends JpaRepository<CreatureAbility, CreatureAbilityId> {
}