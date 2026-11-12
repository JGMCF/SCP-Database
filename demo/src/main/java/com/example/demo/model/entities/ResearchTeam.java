package com.example.demo.model.entities;

import java.util.List;
import com.example.demo.model.enums.ResearchType; 

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;

import jakarta.persistence.*;

@Entity 
@Table(name = "research_team")
public class ResearchTeam {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "compentence_level")
    private Long competenceLevel;

    @Type(ListArrayType.class)
    @Column(name = "research_affinities", columnDefinition = "research_t[]")
    private List<ResearchType> researchAffinities;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false) 
    private Site worksAt;

    public ResearchTeam() {}

    public ResearchTeam(Long competenceLevel, List<ResearchType> researchAffinities) {
        this.competenceLevel = competenceLevel;
        this.researchAffinities = researchAffinities;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getCompetenceLevel() {
        return competenceLevel;
    }

    public void setCompetenceLevel(Long competenceLevel) {
        this.competenceLevel = competenceLevel;
    }

    public List<ResearchType> getResearchAffinities() {
        return researchAffinities;
    }

    public void setResearchAffinities(List<ResearchType> researchAffinities) {
        this.researchAffinities = researchAffinities;
    }

    public Site getWorksAt() {
        return worksAt;
    }

    public void setWorksAt(Site worksAt) {
        this.worksAt = worksAt;
    }
}


