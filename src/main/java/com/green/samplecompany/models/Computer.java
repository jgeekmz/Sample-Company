package com.green.samplecompany.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity for the Computer Object.
 *
 * @author zlatkov
 * @since 27.08.2021
 */
@Entity(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotNull
    private String computerName;
    @NotNull
    private String macAddress;
    @NotNull
    private String ipAddress;
    @NotNull
    private String description;
    private String empAbbr;

    @ManyToOne
    @JoinColumn(name="empId", insertable=false, updatable=false)
    private Employee empAbbreviation;
    private Integer empId;

    public Computer() { }

    public Computer(Integer id, String computerName, String macAddress, String ipAddress, String description,
            String empAbbr, Employee empAbbreviation) {
        this.id = id;
        this.computerName = computerName;
        this.macAddress = macAddress;
        this.ipAddress = ipAddress;
        this.description = description;
        this.empAbbr = empAbbr;
        this.empAbbreviation = empAbbreviation;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getComputerName() { return computerName; }

    public void setComputerName(String computerName) { this.computerName = computerName; }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmpAbbreviation() {
        return empAbbreviation;
    }

    public void setEmpAbbreviation(Employee empAbbreviation) {
        this.empAbbreviation = empAbbreviation;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpAbbr() {
        return empAbbr;
    }

    public void setEmpAbbr(String empAbbr) {
        this.empAbbr = empAbbr;
    }
}
