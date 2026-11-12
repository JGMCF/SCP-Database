package com.example.demo.model.entities;

import com.example.demo.model.enums.AgentRole;
import jakarta.persistence.*;
import com.example.demo.model.entities.Squad;

@Entity
@Table(name = "agent")
@PrimaryKeyJoinColumn(name = "employee_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Agent extends Employee {

    @ManyToOne
    @JoinColumn(name = "member_of", nullable = false)
    protected Squad memberOf;

    @Enumerated(EnumType.STRING)
    @Column(name = "squad_role", nullable = false, columnDefinition = "agent_role")
    protected AgentRole squadRole;

    public Agent() {}

    public Agent(String cpf, Site worksAt, String firstName, String lastName, int salary, Squad memberOf, AgentRole squadRole) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.memberOf = memberOf;
        this.squadRole = squadRole;
    }

    public Squad getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(Squad squad) {
        this.memberOf = squad;
    }

    public AgentRole getSquadRole() {
        return squadRole;
    }

    public void setSquadRole(AgentRole squadRole) {
        this.squadRole = squadRole;
    }
}