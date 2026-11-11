package com.example.demo.repository;

import com.example.demo.model.entities.Commander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommanderRepository extends JpaRepository<Commander, Long> {
}