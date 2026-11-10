package com.example.demo.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class AbilityId implements Serializable {
    private Long creatureId;
    private Long abilityId;

    public AbilityId() {}

    public AbilityId(Long creatureId, Long abilityId) {
        this.creatureId = creatureId;
        this.abilityId = abilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbilityId abilityId1 = (AbilityId) o;
        return Objects.equals(creatureId, abilityId1.creatureId) && Objects.equals(abilityId, abilityId1.abilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatureId, abilityId);
    }
}