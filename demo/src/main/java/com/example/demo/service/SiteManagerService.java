package com.example.demo.service;

import com.example.demo.model.entities.SiteManager;

import com.example.demo.repository.SiteRepository;
import com.example.demo.repository.SiteManagerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SiteManagerService extends BaseService<SiteManager, Long> {

    private final SiteManagerRepository siteManagerRepository;

    public SiteManagerService(SiteManagerRepository siteManagerRepository, SiteRepository siteRepository) {
        this.siteManagerRepository = siteManagerRepository;
    }

    @Override
    protected JpaRepository<SiteManager, Long> getRepository() {
        return siteManagerRepository;
    }

    @Transactional
    public SiteManager findSiteManager(Long siteManagerId){

        SiteManager manager = siteManagerRepository.findById(siteManagerId)
            .orElseThrow(() -> new RuntimeException("Gestor de site nao encontrado"));    
        
        return  manager;
    }

    @Transactional
    public void changeSite(Long siteManagerId, Long siteId){

        SiteManager manager = findSiteManager(siteManagerId);

        boolean managesSite = manager.getManages() != null;

        if (managesSite) {
            throw new RuntimeException("Esse gestor atualmente lidera um site e nao pode mudar");
        }

        manager.setWorksAt(siteId);
        siteManagerRepository.save(manager);
    }

    @Transactional
    public void removeSiteLeadership(Long siteManagerId){

        SiteManager manager = findSiteManager(siteManagerId);
        
        boolean managesSite = manager.getManages() != null;

        if (managesSite) {
            manager.setManages(null);
            siteManagerRepository.save(manager);
        }
        else {
            throw new RuntimeException("Esse gestor nao lidera nenhum site");
        }        
    }

    @Transactional
    public void assignSiteLeadership(Long siteManagerId, Long siteId){

        SiteManager manager = findSiteManager(siteManagerId);

        boolean managesSite = manager.getManages() != null;

        if (managesSite) {
            throw new RuntimeException("Esse gestor ja lidera um site");
        }

        manager.setManages(siteId);
        siteManagerRepository.save(manager);     
    }
}