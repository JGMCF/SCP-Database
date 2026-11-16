package com.example.demo.model.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CreatureAbilityId implements Serializable {

    @Column(name = "creature_id")
    private Long creatureId;

    @Column(name = "ability_id")
    private Long abilityId;

    public CreatureAbilityId() {}

    public CreatureAbilityId(Long creatureId, Long abilityId) {
        this.creatureId = creatureId;
        this.abilityId = abilityId;
    }

    public Long getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(Long creatureId) {
        this.creatureId = creatureId;
    }

    public Long getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Long abilityId) {
        this.abilityId = abilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatureAbilityId that = (CreatureAbilityId) o;
        return Objects.equals(creatureId, that.creatureId) && Objects.equals(abilityId, that.abilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatureId, abilityId);
    }
}