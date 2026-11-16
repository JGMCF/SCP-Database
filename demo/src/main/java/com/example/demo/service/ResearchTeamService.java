package com.example.demo.service;

import com.example.demo.model.entities.ResearchTeam;
import com.example.demo.model.enums.ResearchType;
import com.example.demo.repository.ResearchTeamRepository;
import com.example.demo.repository.SiteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResearchTeamService extends BaseService<ResearchTeam, Long> {

    private final ResearchTeamRepository researchTeamRepository;

    public ResearchTeamService(ResearchTeamRepository researchTeamRepository, SiteRepository siteRepository) {
        this.researchTeamRepository = researchTeamRepository;
    }

    @Override
    protected JpaRepository<ResearchTeam, Long> getRepository() {
        return researchTeamRepository;
    }


    @Transactional
    public ResearchTeam findResearchTeam(Long teamId) {

        ResearchTeam team = researchTeamRepository.findById(teamId)
            .orElseThrow(() -> new RuntimeException("Equipe de pesquisa nao encontrada"));

        return team;
    }


    @Transactional
    public void changeCompetenceLevel(Long teamId, Long newCompetenceLevel) {

        ResearchTeam team = findResearchTeam(teamId);

        team.setCompetenceLevel(newCompetenceLevel);
        researchTeamRepository.save(team);
    }

    @Transactional
    public void changeSite(Long teamId, Long siteId) {
       
        ResearchTeam team = findResearchTeam(teamId);

        team.setSiteId(siteId);
        researchTeamRepository.save(team);
    }

    @Transactional
    public void changeResearchAffinities(Long teamId, List<ResearchType> newAffinities) {
        
        ResearchTeam team = findResearchTeam(teamId);

        team.setResearchAffinities(newAffinities);
        researchTeamRepository.save(team);
    }

    @Transactional
    public void addResearchAffinity(Long teamId, ResearchType affinity) {
       
        ResearchTeam team = findResearchTeam(teamId);

        List<ResearchType> affinities = team.getResearchAffinities();

        if (affinities == null) {
            affinities = new ArrayList<>();
            team.setResearchAffinities(affinities);
        }

        if (!affinities.contains(affinity)) {
            affinities.add(affinity);
            researchTeamRepository.save(team);
        }
    }

    @Transactional
    public void removeResearchAffinity(Long teamId, ResearchType affinity) {
        
        ResearchTeam team = findResearchTeam(teamId);

        List<ResearchType> affinities = team.getResearchAffinities();
        if (affinities != null && affinities.contains(affinity)) {
            affinities.remove(affinity);
            researchTeamRepository.save(team);
        }
    }
}