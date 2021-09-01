package com.green.samplecompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.samplecompany.models.Computer;
import com.green.samplecompany.repositories.ComputerRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlatkov
 */
@Service
@Slf4j
public class ComputerService {

    @Autowired
    private ComputerRepo computerRepo;

    // Add Computer
    public Computer saveComputer(Computer pc) {
        computerRepo.save( pc );
        return pc;
    }

    // Final all pcs
    public List<Computer> findAllPCs() {
        return computerRepo.findAll();
    }

    // Find a pc by id
    public Optional<Computer> findById(Integer id) {
        return computerRepo.findById( id );
    }

    // Delete Computer
    public void delete(int id) {
        computerRepo.deleteById( id );
    }

}
