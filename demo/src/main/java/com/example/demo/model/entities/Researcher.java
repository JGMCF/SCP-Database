package com.example.demo.model.entities;

import java.util.List;
import com.example.demo.model.enums.ResearchType;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import jakarta.persistence.*;

@Entity
@Table(name = "researcher")
@Inheritance(strategy = InheritanceType.JOINED)
public class Researcher extends Employee {

    @Column(name = "member_of", nullable = false)
    private Long memberOf;

    @Type(ListArrayType.class)
    @Column(name = "specialty", columnDefinition = "research_t[]")
    private List<ResearchType> specialty;

    public Researcher() {}

    public Researcher(String cpf, Long worksAt, String firstName, String lastName, int salary, Long memberOf, List<ResearchType> specialty) {
        super(cpf, worksAt, firstName, lastName, salary); 
        this.memberOf = memberOf;
        this.specialty = specialty;
    }

    public Long getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(Long memberOf) {
        this.memberOf = memberOf;
    }

    public List<ResearchType> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<ResearchType> specialty) {
        this.specialty = specialty;
    }
}