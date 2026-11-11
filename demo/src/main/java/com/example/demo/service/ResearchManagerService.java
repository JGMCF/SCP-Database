package com.example.demo.service;

import com.example.demo.model.entities.ResearchManager;
import com.example.demo.repository.ResearchManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResearchManagerService extends BaseService<ResearchManager, Long> {

    @Autowired
    private ResearchManagerRepository researchManagerRepository;

    @Override
    protected JpaRepository<ResearchManager, Long> getRepository() {
        return researchManagerRepository;
    }
}