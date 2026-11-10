package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "research_manager")
public class ResearchManager {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "leads", nullable = false)
    private ResearchTeam leads;

    public ResearchManager() {}

    public ResearchManager(Long employeeId, ResearchTeam leads) {
        this.employeeId = employeeId;
        this.leads = leads;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public ResearchTeam getLeads() {
        return leads;
    }

    public void setLeads(ResearchTeam leads) {
        this.leads = leads;
    }
}