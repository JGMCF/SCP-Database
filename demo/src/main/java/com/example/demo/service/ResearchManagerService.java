package com.example.demo.service;

import com.example.demo.model.entities.ResearchManager;
import com.example.demo.model.entities.Site;
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
    private final SiteRepository siteRepository;

    public ResearchManagerService(ResearchManagerRepository researchManagerRepository, 
        ResearchTeamRepository researchTeamRepository, SiteRepository siteRepository) {
            
        this.researchManagerRepository = researchManagerRepository;
        this.researchTeamRepository = researchTeamRepository;
        this.siteRepository = siteRepository;
    }
    
    @Override
    protected JpaRepository<ResearchManager, Long> getRepository() {
        return researchManagerRepository;
    }

    @Transactional
    public void changeSite(Long managerId, Long siteId) {

        ResearchManager manager = researchManagerRepository.findById(managerId)
            .orElseThrow(() -> new RuntimeException("Gestor de pesquisa nao encontrado"));

        Site newSite = siteRepository.findById(siteId)
            .orElseThrow(() -> new RuntimeException("Site nao encontrado"));

        boolean hasTeam = manager.getLeads() != null;

        if(hasTeam){
            throw new RuntimeException("Esse gestor lidera um time e nao pode mudar de site");
        }
        
        manager.setWorksAt(newSite);
        researchManagerRepository.save(manager);
    }

    @Transactional
    public void assignTeamLeadership(Long managerId, Long teamId){

        ResearchManager manager = researchManagerRepository.findById(managerId)
            .orElseThrow(() -> new RuntimeException("Gestor de pesquisa nao encontrado"));

        ResearchTeam team = researchTeamRepository.findById(teamId)
            .orElseThrow(() -> new RuntimeException("Time nao encontrado"));

        Site currentSite = manager.getWorksAt();

        if(manager.getLeads() != null){
            throw new RuntimeException("Esse gestor ja lidera um time");
        }
        else if(researchManagerRepository.findByLeads(teamId).isPresent()){
            throw new RuntimeException("Esse time ja tem um gestor");
        }
        else if(!currentSite.getSiteId().equals(team.getSiteId().getSiteId())){
            throw new RuntimeException("Esse time se encontra em outro site, transfira o gerente primeiro");
        }
        else {
            manager.setLeads(team);
            researchManagerRepository.save(manager);
        }
    }

    @Transactional
    public void removeTeamLeadership(Long managerId){

        ResearchManager manager = researchManagerRepository.findById(managerId)
            .orElseThrow(() -> new RuntimeException("Gestor de pesquisa nao encontrado"));

        if(manager.getLeads() == null){
            throw new RuntimeException("Esse gestor nao lidera um time");
        }
        else {
            manager.setLeads(null);
            researchManagerRepository.save(manager);
        }
    }
}