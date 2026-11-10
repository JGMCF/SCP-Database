package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "site_manager")
public class SiteManager {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "manages", nullable = false)
    private Site manages;

    public SiteManager() {}

    public SiteManager(Long employeeId, Site manages) {
        this.employeeId = employeeId;
        this.manages = manages;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Site getManages() {
        return manages;
    }

    public void setManages(Site manages) {
        this.manages = manages;
    }
}