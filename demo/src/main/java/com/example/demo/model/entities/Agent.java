package com.example.demo.model.entities;

import com.example.demo.model.enums.AgentRole;
import jakarta.persistence.*;

@Entity
@Table(name = "agent")
@PrimaryKeyJoinColumn(name = "employee_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Agent extends Employee {

    @Column(name = "member_of", nullable = false)
    protected Long memberOf;

    @Enumerated(EnumType.STRING)
    @Column(name = "squad_role", nullable = false, columnDefinition = "agent_role")
    protected AgentRole squadRole;

    public Agent() {}

    public Agent(String cpf, Long worksAt, String firstName, String lastName, int salary, Long memberOf, AgentRole squadRole) {
        super(cpf, worksAt, firstName, lastName, salary);
        this.memberOf = memberOf;
        this.squadRole = squadRole;
    }

    public Long getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(Long memberOf) {
        this.memberOf = memberOf;
    }

    public AgentRole getSquadRole() {
        return squadRole;
    }

    public void setSquadRole(AgentRole squadRole) {
        this.squadRole = squadRole;
    }
}