package com.example.demo.service;

import com.example.demo.model.entities.Research;
import com.example.demo.model.enums.ResearchType;
import com.example.demo.model.enums.StatusType;
import com.example.demo.repository.ResearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Research findResearch(Long researchId) {

        Research research = researchRepository.findById(researchId)
            .orElseThrow(() -> new RuntimeException("Pesquisa nao encontrada"));
        
        return research;
    }

    @Transactional
    public void changeResearchType(Long researchId, ResearchType newType) {

        Research research = findResearch(researchId);

        research.setResearchType(newType);
        researchRepository.save(research);
    }

    @Transactional
    public void changeResearchState(Long researchId, StatusType newState) {

        Research research = findResearch(researchId);

        research.setResearchState(newState);
        researchRepository.save(research);
    }

    @Transactional
    public void changeRisk(Long researchId, int newRisk) {

        Research research = findResearch(researchId);

        research.setRisk(newRisk);
        researchRepository.save(research);
    }

    @Transactional
    public void changeCost(Long researchId, int newCost) {

        Research research = findResearch(researchId);
        
        research.setCost(newCost);
        researchRepository.save(research);
    }
}