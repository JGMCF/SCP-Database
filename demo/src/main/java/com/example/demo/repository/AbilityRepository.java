package com.example.demo.repository;

import com.example.demo.model.entities.Ability;
import com.example.demo.model.entities.AbilityId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, AbilityId> {
}