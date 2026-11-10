package com.example.demo.model.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Pattern(regexp = "^[0-9]{11}$")
    @Column(name = "cpf", length = 11, unique = true, nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "works_at", nullable = false)
    private Site worksAt;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "admission_date")
    private LocalDateTime admissionDate = LocalDateTime.now();

    public Employee() {}

    public Employee(String cpf, Site worksAt, String firstName, String lastName, int salary) {
        this.cpf = cpf;
        this.worksAt = worksAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Site getWorksAt() {
        return worksAt;
    }

    public void setWorksAt(Site worksAt) {
        this.worksAt = worksAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }
}