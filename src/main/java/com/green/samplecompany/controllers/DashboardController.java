package com.green.samplecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.samplecompany.models.Employee;
import com.green.samplecompany.repositories.ComputerRepo;
import com.green.samplecompany.repositories.EmployeeRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlatkov
 * @since 27.08.2021
 */
@Controller
@Slf4j
public class DashboardController {

    private static final int COUNT = 3;
    private static final String ZERO = "Null Employees";

    private EmployeeRepo empRepo;
    private ComputerRepo pcRepo;

    @Autowired
    public DashboardController(EmployeeRepo empRepo, ComputerRepo pcRepo) {
        this.empRepo = empRepo;
        this.pcRepo = pcRepo;
    }

    // Mapping for the index page
    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("pcCount", pcRepo.count());
        model.addAttribute("empCount", empRepo.count());
        List<Employee> collect = empRepo.findAll();

        if (!collect.isEmpty()) {
            for (Employee x : collect) {
                if (x.getPcs().size() >= COUNT) {
                    model.addAttribute("pcToemp", x.getPcs().size());
                }
            }
        } else {
            model.addAttribute("msg", ZERO);
        }

        // Mapping for the assigned PCs to users, counter
        //TODO

        model.addAttribute("pcAssngedCount", "");

        log.info("Inside dashboard controller!");
        return "index";
    }


}
