package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "squad_mission")
public class SquadMission {

    @EmbeddedId
    private SquadMissionId id = new SquadMissionId();

    @Column(name = "creature_id", nullable = true)
    private Long creature;

    public SquadMission() {}

    public SquadMission(Long squadId, Long missionId, Long creature) {
        this.id = new SquadMissionId(squadId, missionId);
        this.creature = creature;
    }

    public SquadMissionId getId() {
        return id;
    }

    public void setId(SquadMissionId id) {
        this.id = id;
    }

    public Long getSquadId() {
        return id != null ? id.getSquadId() : null;
    }

    public void setSquadId(Long squadId) {
        if (this.id == null) {
            this.id = new SquadMissionId();
        }
        this.id.setSquadId(squadId);
    }

    public Long getMissionId() {
        return id != null ? id.getMissionId() : null;
    }

    public void setMissionId(Long missionId) {
        if (this.id == null) {
            this.id = new SquadMissionId();
        }
        this.id.setMissionId(missionId);
    }

    public Long getCreature() {
        return creature;
    }

    public void setCreature(Long creature) {
        this.creature = creature;
    }
}