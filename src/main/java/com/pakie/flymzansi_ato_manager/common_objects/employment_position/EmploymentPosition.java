package com.pakie.flymzansi_ato_manager.common_objects.employment_position;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.person.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employment_position")
public class EmploymentPosition extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "employmentPosition")
    Set<Employee> employees;

    public EmploymentPosition(String title, String description, String details, Set<Employee> employees) {
        super(title, description, details);
        this.employees = employees;
    }

    public EmploymentPosition() {

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
