package com.example.demo.service;

import java.util.List;

import com.example.demo.model.entities.Employee;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ResearcherRepository;
import com.example.demo.repository.ResearchManagerRepository;
import com.example.demo.repository.SiteManagerRepository;
import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.CommanderRepository;
import com.example.demo.repository.SiteRepository;


import com.example.demo.model.enums.AgentRole;
import com.example.demo.model.enums.ResearchType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeService extends BaseService<Employee, Long> {

    private final EmployeeRepository employeeRepository;
    private final ResearcherRepository researcherRepository;
    private final ResearchManagerRepository researchManagerRepository;
    private final SiteManagerRepository siteManagerRepository;
    private final AgentRepository agentRepository;
    private final CommanderRepository commanderRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ResearcherRepository researcherRepository, 
        ResearchManagerRepository researchManagerRepository, SiteManagerRepository siteManagerRepository, 
        AgentRepository agentRepository, CommanderRepository commanderRepository, SiteRepository siteRepository) {

        this.employeeRepository = employeeRepository;
        this.researcherRepository = researcherRepository;
        this.researchManagerRepository = researchManagerRepository;
        this.siteManagerRepository = siteManagerRepository;
        this.agentRepository = agentRepository;
        this.commanderRepository = commanderRepository;
    }

    @Override
    protected JpaRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }

    @Transactional
    public boolean employeeExists(Long employeeId){
         if (!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("Este funcionario ja eh agente.");
        }
        return true;
    }

    @Transactional
    protected void changeSite(Long employeeId, long siteId) {

        employeeExists(employeeId);
        
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));

        employee.setWorksAt(siteId);
        employeeRepository.save(employee);
    }

    @Transactional
    public void changeSalary(Long employeeId, int newSalary) {
        
        employeeExists(employeeId);

        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));

        employee.setSalary(newSalary);
        employeeRepository.save(employee); 
    }

     @Transactional
    public void changeFirstName(Long employeeId, String firstName) {
        
        employeeExists(employeeId);

        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));

        employee.setFirstName(firstName);
        employeeRepository.save(employee); 
    }

     @Transactional
    public void changeLastName(Long employeeId, String lastName) {
        
        employeeExists(employeeId);

        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));

        employee.setLastName(lastName);
        employeeRepository.save(employee); 
    }

    @Transactional
    public void changeCpf(Long employeeId, String cpf) {
        
        employeeExists(employeeId);

        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));

        employee.setCpf(cpf);
        employeeRepository.save(employee); 
    }

    @Transactional
    public void promoteToAgent(Long employeeId, Long squadId, AgentRole role) {
        
        employeeExists(employeeId);

        if (agentRepository.existsById(employeeId)) {
            throw new RuntimeException("Este funcionario ja eh agente.");
        }
        
        agentRepository.insertSubtype(employeeId, squadId, role.name());
    }

     @Transactional
    public void promoteToCommander(Long employeeId, Long squadId) {
        
        employeeExists(employeeId);

        if (commanderRepository.existsById(employeeId)) {
            throw new RuntimeException("Este funcionario ja eh comandante.");
        }
        
        commanderRepository.insertSubtype(employeeId, squadId);
    }

     @Transactional
    public void promoteToResearcher(Long employeeId, List<ResearchType> specialties) {
        
        employeeExists(employeeId);

        if (researcherRepository.existsById(employeeId)) {
            throw new RuntimeException("Este funcionario ja eh pesquisador.");
        }
        
        researcherRepository.insertSubtype(employeeId, specialties);
    }

    @Transactional
    public void promoteToResearchManager(Long employeeId, Long researchTeamId) {

        employeeExists(employeeId);

        if (researchManagerRepository.existsById(employeeId)) {
            throw new RuntimeException("Este funcionario ja eh gestor de pesquia.");
        }
        
        researchManagerRepository.insertSubtype(employeeId, researchTeamId);
    }
   
     @Transactional
    public void promoteToSiteManager(Long employeeId, Long siteId) {

        employeeExists(employeeId);

        if (siteManagerRepository.existsById(employeeId)) {
            throw new RuntimeException("Este funcionario ja eh gestor de site.");
        }
        
        siteManagerRepository.insertSubtype(employeeId, siteId);
    }
}