package com.example.demo.service;

import com.example.demo.model.entities.SquadMission;
import com.example.demo.model.entities.SquadMissionId;
import com.example.demo.repository.SquadMissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SquadMissionService extends BaseService<SquadMission, SquadMissionId> {

    @Autowired
    private SquadMissionRepository repository;

    @Override
    protected JpaRepository<SquadMission, SquadMissionId> getRepository() {
        return repository;
    }
}