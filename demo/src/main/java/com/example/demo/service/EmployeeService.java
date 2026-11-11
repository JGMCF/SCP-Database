package com.example.demo.service;

import com.example.demo.model.entities.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<Employee, Long> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    protected JpaRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }
}