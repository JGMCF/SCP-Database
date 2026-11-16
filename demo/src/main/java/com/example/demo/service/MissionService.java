package com.example.demo.service;

import com.example.demo.model.entities.Mission;
import com.example.demo.model.enums.StatusType;
import com.example.demo.repository.MissionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class MissionService extends BaseService<Mission, Long> {

    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    protected JpaRepository<Mission, Long> getRepository() {
        return missionRepository;
    }

     @Transactional
    public Mission findMission(Long missionId) {

        Mission mission = missionRepository.findById(missionId)
            .orElseThrow(() -> new RuntimeException("Missao nao encontrada"));

        return mission;
    }
    @Transactional
    public void changeMissionDate(Long missionId, LocalDate newDate) {

        Mission mission = findMission(missionId);

        mission.setMissionDate(newDate);
        missionRepository.save(mission);
    }

    @Transactional
    public void changeLocationLatitude(Long missionId, BigDecimal newLatitude) {

        Mission mission = findMission(missionId);

        mission.setLocationLatitude(newLatitude);
        missionRepository.save(mission);
    }

    @Transactional
    public void changeLocationLongitude(Long missionId, BigDecimal newLongitude) {

        Mission mission = findMission(missionId);

        mission.setLocationLongitude(newLongitude);
        missionRepository.save(mission);
    }

    @Transactional
    public void changeMissionStatus(Long missionId, StatusType newStatus) {

        Mission mission = findMission(missionId);

        mission.setMissionStatus(newStatus);
        missionRepository.save(mission);
    }

    @Transactional
    public void changeTotalCasualties(Long missionId, int newCasualties) {

        Mission mission = findMission(missionId);

        mission.setTotalCasualties(newCasualties);
        missionRepository.save(mission);
    }

    @Transactional
    public void changeDescription(Long missionId, String newDescription) {

        Mission mission = findMission(missionId);

        mission.setDescription(newDescription);
        missionRepository.save(mission);
    }
}