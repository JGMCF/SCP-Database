package com.example.demo.service;
import java.util.ArrayList;

import com.example.demo.model.entities.Researcher;
import com.example.demo.model.entities.Site;
import com.example.demo.model.entities.ResearchTeam;

import com.example.demo.repository.ResearcherRepository;
import com.example.demo.repository.SiteRepository;
import com.example.demo.repository.ResearchTeamRepository;

import com.example.demo.model.enums.ResearchType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ResearcherService extends BaseService<Researcher, Long> {

    private final ResearcherRepository researcherRepository;
    private final ResearchTeamRepository researchTeamRepository;
    private final SiteRepository siteRepository;

    public ResearcherService(ResearcherRepository researcherRepository, 
        ResearchTeamRepository researchTeamRepository, SiteRepository siteRepository) {
            
        this.researcherRepository = researcherRepository;
        this.researchTeamRepository = researchTeamRepository;
        this.siteRepository = siteRepository;
    }

    @Override
    protected JpaRepository<Researcher, Long> getRepository() {
        return researcherRepository;
    }

    @Transactional
    public void changeSite(Long researcherId, Long siteId) {

        Researcher researcher = researcherRepository.findById(researcherId)
            .orElseThrow(() -> new RuntimeException("Pesquisador nao encontrado"));

        Site site = siteRepository.findById(siteId)
            .orElseThrow(() -> new RuntimeException("Site nao encontrado"));

        if (researcher.getMemberOf() != null) {
            throw new RuntimeException("Esse pesquisador faz parte de um time e nao pode mudar de site");
        }

        researcher.setWorksAt(site);
        researcherRepository.save(researcher);
    }

    @Transactional
    public void enterTeam(Long researcherId, Long teamId) {

        Researcher researcher = researcherRepository.findById(researcherId)
            .orElseThrow(() -> new RuntimeException("Pesquisador nao encontrado"));
        
        ResearchTeam team = researchTeamRepository.findById(teamId)
            .orElseThrow(() -> new RuntimeException("Time nao encontrado"));


        Site currentSite = researcher.getWorksAt();
        Site teamSite = team.getSiteId();

        if (researcher.getMemberOf() != null){
            throw new RuntimeException("Esse pesquisador ja eh parte de um time.");
        }
        else if(currentSite.getSiteId().equals(teamSite.getSiteId())) {

            researcher.setMemberOf(team);
            researcherRepository.save(researcher);
        }
        else {
            throw new RuntimeException("Esse time esta em um site diferente da do pesquisador, eh necessario transferi-lo de site primeiro.");
        }   
    }

     @Transactional
    public void leaveTeam(Long researcherId) {

         Researcher researcher = researcherRepository.findById(researcherId)
            .orElseThrow(() -> new RuntimeException("Pesquisador nao encontrado"));
        
        researcher.setMemberOf(null);
        researcherRepository.save(researcher);

    }

    @Transactional
    public void addSpecialty(Long researcherId, ResearchType especialty) {

        Researcher researcher = researcherRepository.findById(researcherId)
            .orElseThrow(() -> new RuntimeException("Pesquisador nao encontrado"));
        
        if (researcher.getSpecialty() == null) {
            researcher.setSpecialty(new ArrayList<>());
        }

        if (!researcher.getSpecialty().contains(especialty)) {
            researcher.getSpecialty().add(especialty);
            researcherRepository.save(researcher);
        }
    }

    @Transactional
    public void removeSpecialty(Long researcherId, ResearchType especialty) {

        Researcher researcher = researcherRepository.findById(researcherId)
            .orElseThrow(() -> new RuntimeException("Pesquisador nao encontrado"));

        if (researcher.getSpecialty().contains(especialty)) {
            researcher.getSpecialty().remove(especialty);
            researcherRepository.save(researcher);
        }
        else {
            throw new RuntimeException("Esse pesquisador nao tem essa especialidade");
        }
    }
}