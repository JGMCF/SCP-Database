package com.example.demo.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class TeamConductsResearchId implements Serializable {
    private Long teamId;
    private Long researchId;

    public TeamConductsResearchId() {}

    public TeamConductsResearchId(Long teamId, Long researchId) {
        this.teamId = teamId;
        this.researchId = researchId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getResearchId() {
        return researchId;
    }

    public void setResearchId(Long researchId) {
        this.researchId = researchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamConductsResearchId that = (TeamConductsResearchId) o;
        return Objects.equals(teamId, that.teamId) && Objects.equals(researchId, that.researchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, researchId);
    }
}