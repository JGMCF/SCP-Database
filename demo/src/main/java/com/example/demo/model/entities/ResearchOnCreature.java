package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "research_on_creature")
@IdClass(ResearchOnCreatureId.class)
public class ResearchOnCreature {

    @Id
    @Column(name = "research_id")
    private Long researchId;

    @Id
    @Column(name = "creature_id")
    private Long creatureId;

    @ManyToOne
    @JoinColumn(name = "research_id", insertable = false, updatable = false, nullable = false)
    private Research research;

    @ManyToOne
    @JoinColumn(name = "creature_id", insertable = false, updatable = false, nullable = false)
    private Creature creature;

    public ResearchOnCreature() {}

    public ResearchOnCreature(Long researchId, Long creatureId) {
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

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }
}