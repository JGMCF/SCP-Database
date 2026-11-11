package com.example.demo.service;

import com.example.demo.model.entities.Agent;
import com.example.demo.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgentService extends BaseService<Agent, Long> {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    protected JpaRepository<Agent, Long> getRepository() {
        return agentRepository;
    }
}