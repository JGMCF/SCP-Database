package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "site_manager")
@Inheritance(strategy = InheritanceType.JOINED)
public class SiteManager extends Employee{

    @OneToOne
    @JoinColumn(name = "manages", nullable = false)
    private Site manages;

    public SiteManager() {}

    public SiteManager(String cpf, Site worksAt, String firstName, String lastName, int salary, Site manages) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.manages = manages;
    }

    public Site getManages() {
        return manages;
    }

    public void setManages(Site manages) {
        this.manages = manages;
    }
}