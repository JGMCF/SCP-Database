package com.example.demo.model.entities;

import com.example.demo.model.enums.AgentRole;
import jakarta.persistence.*;
import com.example.demo.model.entities.Squad;
@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "member_of", nullable = false)
    private Squad memberOf;

    @Enumerated(EnumType.STRING)
    @Column(name = "squad_role", nullable = false, columnDefinition = "agent_role")
    private AgentRole squadRole;

    public Agent() {}

    public Agent(Long employeeId, Squad memberOf, AgentRole squadRole) {
        this.employeeId = employeeId;
        this.memberOf = memberOf;
        this.squadRole = squadRole;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Squad getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(Squad memberOf) {
        this.memberOf = memberOf;
    }

    public AgentRole getSquadRole() {
        return squadRole;
    }

    public void setSquadRole(AgentRole squadRole) {
        this.squadRole = squadRole;
    }
}