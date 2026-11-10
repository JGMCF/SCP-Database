package com.example.demo.model.entities;

import com.example.demo.model.enums.CreatureClass;
import com.example.demo.model.enums.CreatureType;
import jakarta.persistence.*;

@Entity
@Table(name = "creature")
public class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creature_id")
    private Long creatureId;

    @Column(name = "creature_codename", length = 50, unique = true, nullable = false)
    private String creatureCodename;

    @ManyToOne
    @JoinColumn(name = "contained_in")
    private Site containedIn;

    @Enumerated(EnumType.STRING)
    @Column(name = "creature_type", columnDefinition = "creature_t")
    private CreatureType creatureType;

    @Column(name = "aggressiveness_level")
    private Integer aggressivenessLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "class", columnDefinition = "creature_class")
    private CreatureClass creatureClass;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    public Creature() {}

    public Creature(String creatureCodename, Site containedIn, CreatureType creatureType, Integer aggressivenessLevel, CreatureClass creatureClass, String name, String description) {
        this.creatureCodename = creatureCodename;
        this.containedIn = containedIn;
        this.creatureType = creatureType;
        this.aggressivenessLevel = aggressivenessLevel;
        this.creatureClass = creatureClass;
        this.name = name;
        this.description = description;
    }

    public Long getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(Long creatureId) {
        this.creatureId = creatureId;
    }

    public String getCreatureCodename() {
        return creatureCodename;
    }

    public void setCreatureCodename(String creatureCodename) {
        this.creatureCodename = creatureCodename;
    }

    public Site getContainedIn() {
        return containedIn;
    }

    public void setContainedIn(Site containedIn) {
        this.containedIn = containedIn;
    }

    public CreatureType getCreatureType() {
        return creatureType;
    }

    public void setCreatureType(CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    public Integer getAggressivenessLevel() {
        return aggressivenessLevel;
    }

    public void setAggressivenessLevel(Integer aggressivenessLevel) {
        this.aggressivenessLevel = aggressivenessLevel;
    }

    public CreatureClass getCreatureClass() {
        return creatureClass;
    }

    public void setCreatureClass(CreatureClass creatureClass) {
        this.creatureClass = creatureClass;
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
}