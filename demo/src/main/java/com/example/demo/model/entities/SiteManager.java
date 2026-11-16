package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "site_manager")
@Inheritance(strategy = InheritanceType.JOINED)
public class SiteManager extends Employee {

    @Column(name = "manages", nullable = false)
    private Long manages;

    public SiteManager() {}

    public SiteManager(String cpf, Long worksAt, String firstName, String lastName, int salary, Long manages) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.manages = manages;
    }

    public Long getManages() {
        return manages;
    }

    public void setManages(Long manages) {
        this.manages = manages;
    }
}