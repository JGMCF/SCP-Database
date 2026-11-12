package com.example.demo.repository;

import com.example.demo.model.entities.Commander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommanderRepository extends JpaRepository<Commander, Long> {

    Optional<Commander> findByCommands(Long squadId);

    @Modifying
    @Query(value = "INSERT INTO commander (employee_id, commands) VALUES (:employeeId, :squadId)", nativeQuery = true)
    void promoteToCommander(@Param("employeeId") Long employeeId, @Param("squadId") Long squadId);

}