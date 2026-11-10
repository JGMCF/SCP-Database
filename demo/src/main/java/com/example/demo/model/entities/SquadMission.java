package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "squad_mission")
@IdClass(SquadMissionId.class)
public class SquadMission {

    @Id
    @Column(name = "squad_id")
    private Long squadId;

    @Id
    @Column(name = "mission_id")
    private Long missionId;

    @ManyToOne
    @JoinColumn(name = "squad_id", insertable = false, updatable = false, nullable = false)
    private Squad squad;

    @ManyToOne
    @JoinColumn(name = "mission_id", insertable = false, updatable = false, nullable = false)
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "creature_id", nullable = true)
    private Creature creature;

    public SquadMission() {}

    public SquadMission(Long squadId, Long missionId, Creature creature) {
        this.squadId = squadId;
        this.missionId = missionId;
        this.creature = creature;
    }

    public Long getSquadId() {
        return squadId;
    }

    public void setSquadId(Long squadId) {
        this.squadId = squadId;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }
}