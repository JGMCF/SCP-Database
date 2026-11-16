package com.example.demo.service;

import com.example.demo.model.entities.Agent;

import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.SquadRepository;

import com.example.demo.model.enums.AgentRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AgentService extends BaseService<Agent, Long> {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository, SquadRepository squadRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    protected JpaRepository<Agent, Long> getRepository() {
        return agentRepository;
    }

    @Transactional
    public Agent findAgent(Long agentId) {

        Agent agent = agentRepository.findById(agentId)
            .orElseThrow(() -> new RuntimeException("Agente nao encontrado"));

        return agent;
    }

    @Transactional
    public void changeRole(Long agentId, AgentRole role) {

        Agent agent = findAgent(agentId);

        agent.setSquadRole(role);
        agentRepository.save(agent);
    }

    @Transactional 
    public void changeSquad(Long agentId, Long squadId) {

        Agent agent = findAgent(agentId);

        agent.setMemberOf(squadId);
        agentRepository.save(agent);
        
    }
}