package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "research_manager")
@Inheritance(strategy = InheritanceType.JOINED)
public class ResearchManager extends Employee {

    @Column(name = "leads", nullable = false)
    protected Long leads;

    public ResearchManager() {}

    public ResearchManager(String cpf, Long worksAt, String firstName, String lastName, int salary, Long leads) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.leads = leads;
    }

    public Long getLeads() {
        return leads;
    }

    public void setLeads(Long leads) {
        this.leads = leads;
    }
}