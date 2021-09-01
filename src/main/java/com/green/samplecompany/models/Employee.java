package com.green.samplecompany.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity for the employee object.
 *
 * @author zlatkov
 * @since 27.08.2021
 */
@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;

    @JsonIgnore
    @OneToMany(mappedBy = "empAbbreviation")
    private List<Computer> pcs;

    /**
     * Default Constructor
     */
    public Employee() {
    }

    public Employee(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Computer> getPcs() {
        return pcs;
    }

    public void setPcs(List<Computer> pcs) {
        this.pcs = pcs;
    }

    @Override public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pcs=" + pcs +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        if (!firstname.equals( employee.firstname ))
            return false;
        if (!lastname.equals( employee.lastname ))
            return false;
        return pcs.equals( employee.pcs );
    }

    @Override public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + pcs.hashCode();
        return result;
    }
}
