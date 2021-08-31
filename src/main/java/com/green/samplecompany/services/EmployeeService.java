package com.green.samplecompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.samplecompany.models.Employee;
import com.green.samplecompany.repositories.EmployeeRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlatkov
 */
@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    // Add Employee in DB
    public void saveEmp(Employee emp) {
        employeeRepo.save(emp);
    }

    // Find all Employees in DB
    public List<Employee> findAllEmps() {
        return employeeRepo.findAll();
    }

    // Find Employee by ID
    public Optional<Employee> findById(Integer id) {
        return employeeRepo.findById(id);
    }

    //Delete Employee in DB
    public void deleteEmployee( Integer id) {
        employeeRepo.deleteById(id);
    }

}
