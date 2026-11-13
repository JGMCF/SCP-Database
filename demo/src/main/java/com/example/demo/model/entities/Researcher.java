package com.example.demo.model.entities;

import java.util.List;
import com.example.demo.model.enums.ResearchType;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import jakarta.persistence.*;

@Entity
@Table(name = "researcher")
@Inheritance(strategy = InheritanceType.JOINED)
public class Researcher extends Employee{

    @ManyToOne
    @JoinColumn(name = "member_of", nullable = false)
    private ResearchTeam memberOf;

    @Type(ListArrayType.class)
    @Column(name = "specialty", columnDefinition = "research_t[]")
    private List<ResearchType> specialty;

    public Researcher() {}

    public Researcher(String cpf, Site worksAt, String firstName, String lastName, int salary, ResearchTeam memberOf, List<ResearchType> specialty) {
        super(cpf, worksAt, firstName, lastName, salary); 
        this.memberOf = memberOf;
        this.specialty = specialty;
}
     public ResearchTeam getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(ResearchTeam team) {
        this.memberOf = team;
    }

    public List<ResearchType> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<ResearchType> specialty) {
        this.specialty = specialty;
    }
}