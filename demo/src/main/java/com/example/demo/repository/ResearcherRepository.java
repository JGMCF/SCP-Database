package com.example.demo.repository;

import com.example.demo.model.entities.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearcherRepository extends JpaRepository<Researcher, Long> {

    @Modifying
    @Query(value = "INSERT INTO research_manager (employee_id, leads) VALUES (:employeeId, :teamId)", nativeQuery = true)
    void insertSubtype(@Param("employeeId") Long employeeId, @Param("teamId") Long teamId);
}