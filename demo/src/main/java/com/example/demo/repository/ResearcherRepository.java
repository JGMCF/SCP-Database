package com.example.demo.repository;

import com.example.demo.model.entities.Researcher;
import com.example.demo.model.enums.ResearchType;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResearcherRepository extends JpaRepository<Researcher, Long> {

    @Modifying
    @Query(value = "INSERT INTO research_manager (employee_id, specialty) VALUES (:employeeId, :specialties)", nativeQuery = true)
    void insertSubtype(@Param("employeeId") Long employeeId, @Param("specialties") List<ResearchType> specialties);
}