package com.example.demo.model.entities;

import java.util.List;
import com.example.demo.model.enums.FieldOperationType; 

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;

import jakarta.persistence.*;

@Entity
@Table(name = "squad")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_id")
    private Long squadID;

    @Column(name = "squad_code", length = 30, unique = true)
    private String squadCodename;

    @Type(ListArrayType.class)
    @Column(name = "specialties", columnDefinition = "field_operation_t[]")
    private List<FieldOperationType> specialties;

    public Squad() {}

    public Squad(String squadCodename, List<FieldOperationType> specialties) {
        this.squadCodename = squadCodename;
        this.specialties = specialties;
    }

    public Long getSquadID() {
        return squadID;
    }

    public void setSquadID(Long squadID) {
        this.squadID = squadID;
    }

    public String getSquadCodename() {
        return squadCodename;
    }

    public void setSquadCodename(String squadCodename) {
        this.squadCodename = squadCodename;
    }

    public List<FieldOperationType> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<FieldOperationType> specialties) {
        this.specialties = specialties;
    }
}