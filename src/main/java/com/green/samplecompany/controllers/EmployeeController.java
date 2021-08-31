package com.green.samplecompany.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.samplecompany.models.Employee;
import com.green.samplecompany.services.EmployeeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlatkov
 * @since 27.08.2021
 */
@Controller
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Mapping for User View Table
    @GetMapping("/employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAllEmps());
        return "employee";
    }

    // Add Employee from the modal form
    @PostMapping(value = "/employees/addNewEmp")
    public String addNew(Employee emp) {
        employeeService.saveEmp(emp);
        return "redirect:/employees";
    }

    // Update Employee from the modal form
    @RequestMapping(value = "employees/updateEmp", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(Employee emp) {
        employeeService.saveEmp(emp);
        return "redirect:/employees";
    }

    // Find all Employees in database
    public List<Employee> findAllEmployeesInDatabase() {
        return employeeService.findAllEmps();
    }

    // Get Employee by ID
    @RequestMapping("/employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id) {
        return employeeService.findById(id);
    }

    // Delete a comptuer
    @RequestMapping(value="/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
