package com.example.demo.service;

import com.example.demo.model.entities.Mission;
import com.example.demo.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MissionService extends BaseService<Mission, Long> {

    @Autowired
    private MissionRepository missionRepository;

    @Override
    protected JpaRepository<Mission, Long> getRepository() {
        return missionRepository;
    }
}