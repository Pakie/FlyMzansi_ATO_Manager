package com.pakie.flymzansi_ato_manager.common_objects.department;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.person.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "department")
    Set<Employee> employees;

    public Department(String title, String description, String details, Set<Employee> employees) {
        super(title, description, details);
        this.employees = employees;
    }

    public Department() {

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
