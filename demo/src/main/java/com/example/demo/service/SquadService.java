package com.example.demo.service;

import com.example.demo.model.entities.Squad;
import com.example.demo.repository.SquadRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SquadService extends BaseService<Squad, Long> {

    private final SquadRepository squadRepository;

    public SquadService(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    @Override
    protected JpaRepository<Squad, Long> getRepository() {
        return squadRepository;
    }
}