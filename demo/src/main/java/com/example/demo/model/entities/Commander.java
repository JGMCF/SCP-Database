package com.example.demo.model.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "commander")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Commander extends Employee {

    @OneToOne
    @JoinColumn(name = "commands", nullable = false)
    private Squad commands;

   public Commander() {}

   public Commander(String cpf, Site worksAt, String firstName, String lastName, int salary, Squad commands) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.commands = commands;
    }

    public Squad getCommands() {
        return commands; 
    }

    public void setCommands(Squad commands) {
        this.commands = commands;
    }
}