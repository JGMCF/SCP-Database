package com.example.demo.repository;

import com.example.demo.model.entities.ResearchManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchManagerRepository extends JpaRepository<ResearchManager, Long> {
}