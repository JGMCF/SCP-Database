package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "commander")
public class Commander {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "commands", nullable = false)
    private Squad commands;

    public Commander() {}

    public Commander(Long employeeId, Squad commands) {
        this.employeeId = employeeId;
        this.commands = commands;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Squad getCommands() {
        return commands; 
    }

    public void setCommands(Squad commands) {
        this.commands = commands;
    }
}