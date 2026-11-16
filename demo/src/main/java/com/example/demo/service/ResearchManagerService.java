package com.example.demo.service;

import com.example.demo.model.entities.ResearchManager;
import com.example.demo.model.entities.ResearchTeam;

import com.example.demo.repository.ResearchManagerRepository;
import com.example.demo.repository.SiteRepository;
import com.example.demo.repository.ResearchTeamRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResearchManagerService extends BaseService<ResearchManager, Long> {

    private final ResearchManagerRepository researchManagerRepository;
    private final ResearchTeamRepository researchTeamRepository;

    public ResearchManagerService(ResearchManagerRepository researchManagerRepository, 
        ResearchTeamRepository researchTeamRepository, SiteRepository siteRepository) {
            
        this.researchManagerRepository = researchManagerRepository;
        this.researchTeamRepository = researchTeamRepository;
    }
    
    @Override
    protected JpaRepository<ResearchManager, Long> getRepository() {
        return researchManagerRepository;
    }

     @Transactional
    public ResearchManager findResearchManager(Long managerId) {

        ResearchManager manager = researchManagerRepository.findById(managerId)
            .orElseThrow(() -> new RuntimeException("Gestor de pesquisa nao encontrado"));

        return manager;
    }

    @Transactional
    public void changeSite(Long managerId, Long siteId) {

        ResearchManager manager = findResearchManager(managerId);

        boolean hasTeam = manager.getLeads() != null;

        if(hasTeam){
            throw new RuntimeException("Esse gestor lidera um time e nao pode mudar de site");
        }
        
        manager.setWorksAt(siteId);
        researchManagerRepository.save(manager);
    }

    @Transactional
    public void assignTeamLeadership(Long managerId, Long teamId){

        ResearchManager manager = findResearchManager(managerId);

        ResearchTeam team = researchTeamRepository.findById(teamId)
            .orElseThrow(() -> new RuntimeException("Time nao encontrado"));

        Long currentSite = manager.getWorksAt();

        if(manager.getLeads() != null){
            throw new RuntimeException("Esse gestor ja lidera um time");
        }
        else if(researchManagerRepository.findByLeads(teamId).isPresent()){
            throw new RuntimeException("Esse time ja tem um gestor");
        }
        else if(!currentSite.equals(team.getSiteId())){
            throw new RuntimeException("Esse time se encontra em outro site, transfira o gerente primeiro");
        }
        else {
            manager.setLeads(teamId);
            researchManagerRepository.save(manager);
        }
    }

    @Transactional
    public void removeTeamLeadership(Long managerId){

        ResearchManager manager = findResearchManager(managerId);

        if(manager.getLeads() == null){
            throw new RuntimeException("Esse gestor nao lidera um time");
        }
        else {
            manager.setLeads(null);
            researchManagerRepository.save(manager);
        }
    }
}