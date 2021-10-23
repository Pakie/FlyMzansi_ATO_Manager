package com.pakie.flymzansi_ato_manager.common_objects.employment_type;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.person.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employment_type")
public class EmploymentType extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "employmentType")
    Set<Employee> employees;

    public EmploymentType(String title, String description, String details, Set<Employee> employees) {
        super(title, description, details);
        this.employees = employees;
    }

    public EmploymentType() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}