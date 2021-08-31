package com.green.samplecompany.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.green.samplecompany.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository <Employee, Integer> {

    @Query(value = "select e from employee e where e.pcs >= :count")
    List<Employee> findEmployeeByPcsIsGreaterThanEqual(Integer count);


}
