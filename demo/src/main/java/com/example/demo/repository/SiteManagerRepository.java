package com.example.demo.repository;

import com.example.demo.model.entities.SiteManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteManagerRepository extends JpaRepository<SiteManager, Long> {
}