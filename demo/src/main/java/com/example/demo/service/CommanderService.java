package com.example.demo.service;

import com.example.demo.model.entities.Commander;
import com.example.demo.repository.CommanderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CommanderService extends BaseService<Commander, Long> {

    @Autowired
    private CommanderRepository commanderRepository;

    @Override
    protected JpaRepository<Commander, Long> getRepository() {
        return commanderRepository;
    }
}