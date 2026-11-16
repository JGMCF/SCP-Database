package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "commander")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Commander extends Employee {

    @Column(name = "commands", nullable = false)
    private Long commands;

    public Commander() {}

    public Commander(String cpf, Long worksAt, String firstName, String lastName, int salary, Long commands) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.commands = commands;
    }

    public Long getCommands() {
        return commands; 
    }

    public void setCommands(Long commands) {
        this.commands = commands;
    }
}