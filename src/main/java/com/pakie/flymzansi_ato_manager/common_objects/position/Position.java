package com.pakie.flymzansi_ato_manager.common_objects.position;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.person.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position extends CommonObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "position")
    Set<Employee> employees;

    public Position(String title, String description, String details, Long id, Set<Employee> employees) {
        super(title, description, details);
        this.id = id;
        this.employees = employees;
    }

    public Position() {

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
