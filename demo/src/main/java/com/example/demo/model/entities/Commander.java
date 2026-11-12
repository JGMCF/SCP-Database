package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "commander")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Commander extends Agent {

    @OneToOne
    @JoinColumn(name = "commands", nullable = false)
    private Squad commands;

   public Commander() {}

   public Commander(String cpf, Site worksAt, String firstName, String lastName, int salary, Squad memberOf, AgentRole squadRole, Squad commands) {
        super(cpf, worksAt, firstName, lastName, salary, memberOf, squadRole);
        this.commands = commands;
    }

    public Squad getCommands() {
        return commands; 
    }

    public void setCommands(Squad commands) {
        this.commands = commands;
    }
}