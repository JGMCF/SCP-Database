package com.example.demo.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class SquadMissionId implements Serializable {
    private Long squadId;
    private Long missionId;

    public SquadMissionId() {}

    public SquadMissionId(Long squadId, Long missionId) {
        this.squadId = squadId;
        this.missionId = missionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquadMissionId that = (SquadMissionId) o;
        return Objects.equals(squadId, that.squadId) && Objects.equals(missionId, that.missionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squadId, missionId);
    }
}