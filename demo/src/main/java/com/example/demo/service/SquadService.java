package com.example.demo.service;

import com.example.demo.model.entities.Squad;
import com.example.demo.model.enums.FieldOperationType;
import com.example.demo.repository.SquadRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


     @Transactional
    public Squad findSquad(Long squadId) {

        Squad squad = squadRepository.findById(squadId)
            .orElseThrow(() -> new RuntimeException("Esquadrao nao encontrado"));

        return squad;
    }
    @Transactional
    public void changeSquadCodename(Long squadId, String newCodename) {

        Squad squad = findSquad(squadId);

        squad.setSquadCodename(newCodename);
        squadRepository.save(squad);
    }

    @Transactional
    public void changeSpecialties(Long squadId, List<FieldOperationType> newSpecialties) {

        Squad squad = findSquad(squadId);

        squad.setSpecialties(newSpecialties);
        squadRepository.save(squad);
    }

    @Transactional
    public void addSpecialty(Long squadId, FieldOperationType specialty) {

        Squad squad = findSquad(squadId);

        List<FieldOperationType> specialties = squad.getSpecialties();

        if (specialties == null) {
            specialties = new ArrayList<>();
            squad.setSpecialties(specialties);
        }

        if (!specialties.contains(specialty)) {
            specialties.add(specialty);
            squadRepository.save(squad);
        }
    }

    @Transactional
    public void removeSpecialty(Long squadId, FieldOperationType specialty) {

        Squad squad = findSquad(squadId);

        List<FieldOperationType> specialties = squad.getSpecialties();
        
        if (specialties != null && specialties.contains(specialty)) {
            specialties.remove(specialty);
            squadRepository.save(squad);
        }
    }
}