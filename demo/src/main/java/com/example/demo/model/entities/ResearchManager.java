package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "research_manager")
@Inheritance(strategy = InheritanceType.JOINED)
public class ResearchManager extends Employee{

    @OneToOne
    @JoinColumn(name = "leads", nullable = false)
    protected ResearchTeam leads;

    public ResearchManager() {}

    public ResearchManager(String cpf, Site worksAt, String firstName, String lastName, int salary, ResearchTeam leads) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.leads = leads;
    }

    public ResearchTeam getLeads() {
        return leads;
    }

    public void setLeads(ResearchTeam leads) {
        this.leads = leads;
    }
}