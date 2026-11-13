package com.example.demo.service;

import com.example.demo.model.entities.Agent;
import com.example.demo.model.entities.Squad;

import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.SquadRepository;

import com.example.demo.model.enums.AgentRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AgentService extends BaseService<Agent, Long> {

    private final AgentRepository agentRepository;
    private final SquadRepository squadRepository;

    public AgentService(AgentRepository agentRepository, SquadRepository squadRepository) {
        this.agentRepository = agentRepository;
        this.squadRepository = squadRepository;
    }

    @Override
    protected JpaRepository<Agent, Long> getRepository() {
        return agentRepository;
    }

    @Transactional
    public void changeRole(Long agentId, AgentRole role) {

        Agent agent = agentRepository.findById(agentId)
            .orElseThrow(() -> new RuntimeException("Agente nao encontrado"));

        agent.setSquadRole(role);
        agentRepository.save(agent);
    }

    @Transactional 
    public void changeSquad(Long agentId, Long squadId) {

        Agent agent = agentRepository.findById(agentId)
            .orElseThrow(() -> new RuntimeException("Agente nao encontrado"));
        
        Squad squad = squadRepository.findById(squadId)
            .orElseThrow(() -> new RuntimeException("Squad nao encontrado"));

        agent.setMemberOf(squad);
        agentRepository.save(agent);
        
    }
}