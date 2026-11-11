package com.example.demo.service;

import com.example.demo.model.entities.Researcher;
import com.example.demo.repository.ResearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResearcherService extends BaseService<Researcher, Long> {

    @Autowired
    private ResearcherRepository researcherRepository;

    @Override
    protected JpaRepository<Researcher, Long> getRepository() {
        return researcherRepository;
    }
}