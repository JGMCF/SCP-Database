package com.example.demo.model.entities;

import com.example.demo.model.enums.ResearchType;
import com.example.demo.model.enums.StatusType;

import jakarta.persistence.*;


@Entity 
@Table(name = "research")
public class Research {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "research_id")
    private long researchID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "research_type")
    private ResearchType researchType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "research_state")
    private StatusType researchState;

    @Column(nullable = false, name = "risk")
    private int risk;

    @Column(nullable = false, name = "cost")
    private int cost;

    public Research() {}

    public Research(ResearchType researchType, StatusType researchState, int risk, int cost) {
        this.researchType = researchType;
        this.researchState = researchState;
        this.risk = risk;
        this.cost = cost;
    }

    public long getResearchID() {
        return researchID;
    }

    public void setResearchID(long researchID) {
        this.researchID = researchID;
    }

    public ResearchType getResearchType() {
        return researchType;
    }

    public void setResearchType(ResearchType researchType) {
        this.researchType = researchType;
    }

    public StatusType getResearchState() {
        return researchState;
    }

    public void setResearchState(StatusType researchState) {
        this.researchState = researchState;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

