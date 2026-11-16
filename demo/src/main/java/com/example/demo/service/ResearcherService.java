package com.example.demo.service;
import java.util.ArrayList;

import com.example.demo.model.entities.Researcher;
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

    public ResearcherService(ResearcherRepository researcherRepository, 
        ResearchTeamRepository researchTeamRepository, SiteRepository siteRepository) {
            
        this.researcherRepository = researcherRepository;
        this.researchTeamRepository = researchTeamRepository;
    }

    @Override
    protected JpaRepository<Researcher, Long> getRepository() {
        return researcherRepository;
    }

       @Transactional
    public Researcher findResearcher(Long researcherId) {

        Researcher researcher = researcherRepository.findById(researcherId)
            .orElseThrow(() -> new RuntimeException("Pesquisador nao encontrado"));
        
        return researcher;
    }

    @Transactional
    public void changeSite(Long researcherId, Long siteId) {

        Researcher researcher = findResearcher(researcherId);

        if (researcher.getMemberOf() != null) {
            throw new RuntimeException("Esse pesquisador faz parte de um time e nao pode mudar de site");
        }

        researcher.setWorksAt(siteId);
        researcherRepository.save(researcher);
    }

    @Transactional
    public void enterTeam(Long researcherId, Long teamId) {

        Researcher researcher = findResearcher(researcherId);
        
        ResearchTeam team = researchTeamRepository.findById(teamId)
            .orElseThrow(() -> new RuntimeException("Time nao encontrado"));

        Long currentSite = researcher.getWorksAt();
        Long teamSite = team.getSiteId();

        if (researcher.getMemberOf() != null){
            throw new RuntimeException("Esse pesquisador ja eh parte de um time.");
        }
        else if(currentSite.equals(teamSite)) {

            researcher.setMemberOf(teamId);
            researcherRepository.save(researcher);
        }
        else {
            throw new RuntimeException("Esse time esta em um site diferente da do pesquisador, eh necessario transferi-lo de site primeiro.");
        }   
    }

     @Transactional
    public void leaveTeam(Long researcherId) {

        Researcher researcher = findResearcher(researcherId);
        
        researcher.setMemberOf(null);
        researcherRepository.save(researcher);

    }

    @Transactional
    public void addSpecialty(Long researcherId, ResearchType especialty) {

        Researcher researcher = findResearcher(researcherId);
        
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

        Researcher researcher = findResearcher(researcherId);

        if (researcher.getSpecialty().contains(especialty)) {
            researcher.getSpecialty().remove(especialty);
            researcherRepository.save(researcher);
        }
        else {
            throw new RuntimeException("Esse pesquisador nao tem essa especialidade");
        }
    }
}