package com.example.demo.repository;

import com.example.demo.model.entities.SquadMission;
import com.example.demo.model.entities.SquadMissionId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadMissionRepository extends JpaRepository<SquadMission, SquadMissionId> {
}