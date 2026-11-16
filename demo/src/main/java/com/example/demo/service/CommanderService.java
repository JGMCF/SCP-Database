package com.example.demo.service;

import com.example.demo.model.entities.Commander;

import com.example.demo.repository.CommanderRepository;
import com.example.demo.repository.SquadRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommanderService extends BaseService<Commander, Long> {

    private final CommanderRepository commanderRepository;

    public CommanderService(CommanderRepository commanderRepository, SquadRepository squadRepository) {
        this.commanderRepository = commanderRepository;
    }

    @Override
    protected JpaRepository<Commander, Long> getRepository() {
        return commanderRepository;
    }

    @Transactional
    public Commander findCommander(Long commanderId) {
       
        Commander commander = commanderRepository.findById(commanderId)
            .orElseThrow(() -> new RuntimeException("Comandante nao encontrado"));

        return  commander;
    }

    @Transactional
    public void assignCommand(Long commanderId, Long squadId) {
       
        Commander commander = findCommander(commanderId);
        boolean squadHasCommander = commanderRepository.findByCommands(squadId).isPresent();

        if (squadHasCommander) {
            throw new RuntimeException("Esse esquadrao ja tem um comandante.");
        }
        else {
            commander.setCommands(squadId);
            commanderRepository.save(commander);
        }
    }

    @Transactional
    public void removeCommand(Long commanderId) {
       
        Commander commander = findCommander(commanderId);

        commander.setCommands(null);
        commanderRepository.save(commander);
    }
}