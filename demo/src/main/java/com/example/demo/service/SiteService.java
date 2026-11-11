package com.example.demo.service;

import com.example.demo.model.entities.Site;
import com.example.demo.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SiteService extends BaseService<Site, Long> {

    @Autowired
    private SiteRepository siteRepository;

    @Override
    protected JpaRepository<Site, Long> getRepository() {
        return siteRepository;
    }
}