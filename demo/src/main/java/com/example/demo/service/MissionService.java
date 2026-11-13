package com.example.demo.service;

import com.example.demo.model.entities.Mission;
import com.example.demo.repository.MissionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MissionService extends BaseService<Mission, Long> {

    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    protected JpaRepository<Mission, Long> getRepository() {
        return missionRepository;
    }
}