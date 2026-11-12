package com.example.demo.repository;

import com.example.demo.model.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Modifying
    @Query(value = "INSERT INTO agent (employee_id, member_of, squad_role) VALUES (:employeeId, :squadId, :squadRole)", nativeQuery = true)
    void insertSubtype(@Param("employeeId") Long employeeId, @Param("squadId") Long squadId, @Param("squadRole") String squadRole);
}