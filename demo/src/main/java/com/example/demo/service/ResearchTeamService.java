package com.example.demo.service;

import com.example.demo.model.entities.ResearchTeam;
import com.example.demo.repository.ResearchTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ResearchTeamService extends BaseService<ResearchTeam, Long> {

    @Autowired
    private ResearchTeamRepository researchTeamRepository;

    @Override
    protected JpaRepository<ResearchTeam, Long> getRepository() {
        return researchTeamRepository;
    }
}