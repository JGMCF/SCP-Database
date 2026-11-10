package com.example.demo.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class ResearchOnCreatureId implements Serializable {
    private Long researchId;
    private Long creatureId;

    public ResearchOnCreatureId() {}

    public ResearchOnCreatureId(Long researchId, Long creatureId) {
        this.researchId = researchId;
        this.creatureId = creatureId;
    }

    public Long getResearchId() {
        return researchId;
    }

    public void setResearchId(Long researchId) {
        this.researchId = researchId;
    }

    public Long getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(Long creatureId) {
        this.creatureId = creatureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchOnCreatureId that = (ResearchOnCreatureId) o;
        return Objects.equals(researchId, that.researchId) && Objects.equals(creatureId, that.creatureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(researchId, creatureId);
    }
}