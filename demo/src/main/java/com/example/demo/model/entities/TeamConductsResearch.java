package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "team_conducts_research")
@IdClass(TeamConductsResearchId.class)
public class TeamConductsResearch {

    @Id
    @Column(name = "team_id")
    private Long teamId;

    @Id
    @Column(name = "research_id")
    private Long researchId;

    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false, nullable = false)
    private ResearchTeam team;

    @ManyToOne
    @JoinColumn(name = "research_id", insertable = false, updatable = false, nullable = false)
    private Research research;

    public TeamConductsResearch() {}

    public TeamConductsResearch(Long teamId, Long researchId) {
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

    public ResearchTeam getTeam() {
        return team;
    }

    public void setTeam(ResearchTeam team) {
        this.team = team;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }
}