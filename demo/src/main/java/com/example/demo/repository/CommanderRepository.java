package com.example.demo.repository;

import com.example.demo.model.entities.Commander;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommanderRepository extends JpaRepository<Commander, Long> {

    Optional<Commander> findByCommands(Long squadId);

    @Modifying
    @Query(value = "INSERT INTO commander (employee_id, commands) VALUES (:employeeId, :squadId)", nativeQuery = true)
    void insertSubtype(@Param("employeeId") Long employeeId, @Param("squadId") Long squadId);

}