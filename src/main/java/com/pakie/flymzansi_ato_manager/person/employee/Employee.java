package com.pakie.flymzansi_ato_manager.person.employee;

import com.pakie.flymzansi_ato_manager.common_objects.department.Department;
import com.pakie.flymzansi_ato_manager.common_objects.position.Position;
import com.pakie.flymzansi_ato_manager.common_objects.employment_type.EmploymentType;
import com.pakie.flymzansi_ato_manager.person.Person;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    private Double salary;
    private Long taxNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    private EmploymentType employmentType;

    @ManyToOne(fetch = FetchType.EAGER)
    private Position position;

    public Employee(String firstName, String lastName, String email, String cell, String address, LocalDate startDate, Double salary, Long taxNumber, Department department, EmploymentType employmentType, Position position) {
        super(firstName, lastName, email, cell, address);
        this.startDate = startDate;
        this.salary = salary;
        this.taxNumber = taxNumber;
        this.department = department;
        this.employmentType = employmentType;
        this.position = position;
    }

    public Employee() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(Long taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
