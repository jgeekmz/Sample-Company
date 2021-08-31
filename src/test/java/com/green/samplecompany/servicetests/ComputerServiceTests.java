package com.green.samplecompany.servicetests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.green.samplecompany.models.Computer;
import com.green.samplecompany.models.Employee;
import com.green.samplecompany.repositories.ComputerRepo;
import com.green.samplecompany.services.ComputerService;
import static org.mockito.Mockito.times;

/**
 * @author zlatkov
 */
@RunWith(MockitoJUnitRunner.class)
public class ComputerServiceTests{

    private static final int ID = 1;
    private static final String NAME = "TestPC01";

    @Mock
    private ComputerRepo pcRepo;
    @InjectMocks
    private ComputerService pcService;

    //№1
    @Test
    @DisplayName("Create Computer Test")
    public void createPC(){
        List<Computer> pcDatabase = loadPCTestData();
        when(pcRepo.findAll()).thenReturn(pcDatabase);
        //test
        List<Computer> listPCs = pcService.findAllPCs();
        assertEquals(2, listPCs.size());
        verify(pcRepo, times(1)).findAll();
    }


    // Helper Method for Test Data
    // PC Test Data
    public List<Computer> loadPCTestData(){
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstname("Martin");
        emp1.setLastname("Zlatkov");

        Computer pc1 = new Computer();
        pc1.setId(1);
        pc1.setComputerName("PC01");
        pc1.setMacAddress("00-80-41-ae-fd-7e");
        pc1.setIpAddress("192.168.0.1");
        pc1.setEmpAbbreviation(emp1);
        pc1.setEmpAbbr("zla");
        pc1.setEmpId(1);

        Computer pc2 = new Computer();
        pc2.setId(2);
        pc2.setComputerName("PC01");
        pc2.setMacAddress("00-80-41-ae-fd-7e");
        pc2.setIpAddress("192.168.0.1");
        pc2.setEmpAbbreviation(emp1);
        pc2.setEmpAbbr("zla");
        pc2.setEmpId(1);

        List<Computer> pc = new ArrayList<>();
        pc.add(pc1);
        pc.add(pc2);

        return pc;
    }


}
