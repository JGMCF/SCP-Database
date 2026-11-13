package com.example.demo.service;

import com.example.demo.model.entities.Research;
import com.example.demo.repository.ResearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class ResearchService extends BaseService<Research, Long> {

    private final ResearchRepository researchRepository;

    public ResearchService(ResearchRepository researchRepository) {
        this.researchRepository = researchRepository;
    }

    @Override
    protected JpaRepository<Research, Long> getRepository() {
        return researchRepository;
    }
}