package com.example.demo.repository;

import com.example.demo.model.entities.SquadMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadMissionRepository extends JpaRepository<SquadMission, Long> {
}