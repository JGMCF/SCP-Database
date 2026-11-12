package com.example.demo.repository;

import com.example.demo.model.entities.SiteManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteManagerRepository extends JpaRepository<SiteManager, Long> {

    @Modifying
    @Query(value = "INSERT INTO site_manager (employee_id, manages) VALUES (:employeeId, :siteId)", nativeQuery = true)
    void insertSubtype(@Param("employeeId") Long employeeId, @Param("siteId") Long valueId);
}