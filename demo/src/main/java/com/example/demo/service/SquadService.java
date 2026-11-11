package com.example.demo.service;

import com.example.demo.model.entities.Squad;
import com.example.demo.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SquadRepository extends BaseService<Squad, Long> {

    @Autowired
    private SquadRepository squadRepository;

    @Override
    protected JpaRepository<Squad, Long> getRepository() {
        return squadRepository;
    }
}

