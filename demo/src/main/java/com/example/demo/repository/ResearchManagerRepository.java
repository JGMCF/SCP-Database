package com.example.demo.repository;

import com.example.demo.model.entities.ResearchManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchManagerRepository extends JpaRepository<ResearchManager, Long> {
    
        Optional<ResearchManager> findByLeads(Long researchTeamId);

        @Modifying
        @Query(value = "INSERT INTO research_manager (employee_id, leads) VALUES (:employeeId, :teamId)", nativeQuery = true)
        void insertSubtype(@Param("employeeId") Long employeeId, @Param("teamId") Long valueId);

}