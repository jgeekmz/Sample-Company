package com.green.samplecompany.servicetests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.green.samplecompany.models.Employee;
import com.green.samplecompany.repositories.EmployeeRepo;
import com.green.samplecompany.services.EmployeeService;

/**
 * @autor zlatkov
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepo empRepo;
    @InjectMocks
    private EmployeeService empService;

    @Test
    public void testCreateEmployee() {
        List<Employee> empDatabase = loadTestDataEmployees();
        when( empRepo.findAll() ).thenReturn( empDatabase );

        //test
        List<Employee> listPCs = empService.findAllEmps();
        assertEquals( 2, listPCs.size() );
        verify( empRepo, times( 1 ) ).findAll();
    }

    @Test
    public void testDeleteEmployee() {
        //TODO
    }

    //    @Test
    //    public Employee findEmployeeById() {
    //        Employee emp = new Employee();
    //        return emp;
    //    }

    @Test
    public void testUpdateEmployee() {
        //TODO
    }

    private List<Employee> loadTestDataEmployees() {
        Employee emp1 = new Employee( 1, "Martin", "Zlatkov" );
        Employee emp2 = new Employee( 2, "Ivan", "Dimitrov" );

        List<Employee> listEmps = new ArrayList<>();
        listEmps.add( emp1 );
        listEmps.add( emp2 );

        return listEmps;
    }


}
