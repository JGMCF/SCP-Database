package com.example.demo.repository;

import com.example.demo.model.entities.Research;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchRepository extends JpaRepository<Research, Long> {
}