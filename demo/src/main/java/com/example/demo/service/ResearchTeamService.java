package com.example.demo.service;

import com.example.demo.model.entities.ResearchTeam;
import com.example.demo.repository.ResearchTeamRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResearchTeamService extends BaseService<ResearchTeam, Long> {

    private final ResearchTeamRepository researchTeamRepository;

    public ResearchTeamService(ResearchTeamRepository researchTeamRepository) {
        this.researchTeamRepository = researchTeamRepository;
    }

    @Override
    protected JpaRepository<ResearchTeam, Long> getRepository() {
        return researchTeamRepository;
    }
}