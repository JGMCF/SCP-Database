package com.example.demo.service;

import com.example.demo.model.entities.Commander;
import com.example.demo.model.entities.Squad;

import com.example.demo.repository.CommanderRepository;
import com.example.demo.repository.SquadRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommanderService extends BaseService<Commander, Long> {

    private final CommanderRepository commanderRepository;
    private final SquadRepository squadRepository;

    public CommanderService(CommanderRepository commanderRepository, SquadRepository squadRepository) {
        this.commanderRepository = commanderRepository;
        this.squadRepository = squadRepository;
    }

    @Override
    protected JpaRepository<Commander, Long> getRepository() {
        return commanderRepository;
    }

    @Transactional
    public void assignCommand(Long commanderId, Long squadId) {
       
        Commander commander = commanderRepository.findById(commanderId)
            .orElseThrow(() -> new RuntimeException("Comandante nao encontrado"));
        
        Squad squad = squadRepository.findById(squadId)
            .orElseThrow(() -> new RuntimeException("Esquadrao nao encontrado"));

        boolean squadHasCommander = commanderRepository.findByCommands(squadId).isPresent();

        if (squadHasCommander) {
            throw new RuntimeException("Esse esquadrao ja tem um comandante.");
        }
        else {
            commander.setCommands(squad);
            commanderRepository.save(commander);
        }
    }

    @Transactional
    public void removeCommand(Long commanderId) {
       
        Commander commander = commanderRepository.findById(commanderId)
            .orElseThrow(() -> new RuntimeException("Comandante nao encontrado"));

        commander.setCommands(null);
        commanderRepository.save(commander);
    }
}