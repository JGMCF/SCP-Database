package com.example.demo.model.entities;

import java.util.List;
import com.example.demo.model.enums.ResearchType;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import jakarta.persistence.*;

@Entity
@Table(name = "researcher")
public class Researcher {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "member_of", nullable = false)
    private ResearchTeam memberOf;

    @Type(ListArrayType.class)
    @Column(name = "specialty", columnDefinition = "research_t[]")
    private List<ResearchType> specialty;

    public Researcher() {}

    public Researcher(Long employeeId, ResearchTeam memberOf, List<ResearchType> specialty) {
        this.employeeId = employeeId;
        this.memberOf = memberOf;
        this.specialty = specialty;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public ResearchTeam getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(ResearchTeam memberOf) {
        this.memberOf = memberOf;
    }

    public List<ResearchType> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<ResearchType> specialty) {
        this.specialty = specialty;
    }
}