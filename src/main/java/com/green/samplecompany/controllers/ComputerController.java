package com.green.samplecompany.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.samplecompany.models.Computer;
import com.green.samplecompany.services.ComputerService;
import com.green.samplecompany.services.EmployeeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlatkov
 * @since 27.08.2021
 */
@Controller
@Slf4j
public class ComputerController {

    @Autowired
    private ComputerService computerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/computers")
    public String showComputers(Model model) {
        model.addAttribute( "computers", computerService.findAllPCs() );
        model.addAttribute( "employees", employeeService.findAllEmps() );
        return "computer";
    }

    //Add Computer
    @PostMapping(value = "/computers/addNewComputer")
    public String addNew(Computer pc, Model model) {
        model.addAttribute( "computers", computerService.findAllPCs() );
        if (pc == null) {
            //log.info( "pc Object ist empty!" );
        } else {
            computerService.saveComputer( pc );
        }
        return "redirect:/computers";
    }

    //Get Compuer by ID
    @RequestMapping("/computers/findById")
    @ResponseBody
    public Optional<Computer> findById(Model model, Integer id) {
        model.addAttribute( "emoployees", employeeService.findAllEmps() );
        return computerService.findById( id );
    }

    // Update a comptuer
    @RequestMapping(value = "computers/update", method = { RequestMethod.PUT, RequestMethod.GET })
    public String update(Computer pc) {
        if (pc == null) {
            //log.info( "pc Object ist empty!" );
        } else {
            computerService.saveComputer( pc );
        }
        return "redirect:/computers";
    }

    // Delete a comptuer
    @RequestMapping(value = "/computers/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String delete(Integer id) {
        computerService.delete( id );
        return "redirect:/computers";
    }

}
