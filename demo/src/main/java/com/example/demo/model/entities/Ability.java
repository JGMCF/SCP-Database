package com.example.demo.model.entities;

import com.example.demo.model.enums.CreatureType;
import jakarta.persistence.*;
    
@Entity
@Table(name = "ability")
@IdClass(AbilityId.class)
public class Ability {

    @Id
    @Column(name = "creature_id")
    private Long creatureId;

    @Id
    @Column(name = "ability_id")
    private Long abilityId;

    @ManyToOne
    @JoinColumn(name = "creature_id", insertable = false, updatable = false, nullable = false)
    private Creature creature;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "frequency")
    private Integer frequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "ability_type", nullable = false, columnDefinition = "creature_t")
    private CreatureType abilityType;

    public Ability() {}

    public Ability(Long creatureId, Long abilityId, String name, String description, Integer frequency, CreatureType abilityType) {
        this.creatureId = creatureId;
        this.abilityId = abilityId;
        this.name = name;
        this.description = description;
        this.frequency = frequency;
        this.abilityType = abilityType;
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

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public CreatureType getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(CreatureType abilityType) {
        this.abilityType = abilityType;
    }

}