package com.green.samplecompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.samplecompany.models.Computer;

@Repository
public interface ComputerRepo extends JpaRepository<Computer, Integer> {


}
