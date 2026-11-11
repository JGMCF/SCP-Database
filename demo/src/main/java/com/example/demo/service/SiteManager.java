package com.example.demo.service;

import com.example.demo.model.entities.SiteManager;
import com.example.demo.repository.SiteManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SiteManagerService extends BaseService<SiteManager, Long> {

    @Autowired
    private SiteManagerRepository siteManagerRepository;

    @Override
    protected JpaRepository<SiteManager, Long> getRepository() {
        return siteManagerRepository;
    }
}