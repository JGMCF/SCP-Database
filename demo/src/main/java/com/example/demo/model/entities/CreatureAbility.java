package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "creature_ability")
public class CreatureAbility {

    @EmbeddedId
    private CreatureAbilityId id = new CreatureAbilityId();

    public CreatureAbility() {}

    public CreatureAbility(Long creatureId, Long abilityId) {
        this.id = new CreatureAbilityId(creatureId, abilityId);
    }

    public CreatureAbilityId getId() {
        return id;
    }

    public void setId(CreatureAbilityId id) {
        this.id = id;
    }

    public Long getCreatureId() {
        return id != null ? id.getCreatureId() : null;
    }

    public void setCreatureId(Long creatureId) {
        this.id.setCreatureId(creatureId);
    }

    public Long getAbilityId() {
        return id != null ? id.getAbilityId() : null;
    }

    public void setAbilityId(Long abilityId) {
        this.id.setAbilityId(abilityId);
    }
}