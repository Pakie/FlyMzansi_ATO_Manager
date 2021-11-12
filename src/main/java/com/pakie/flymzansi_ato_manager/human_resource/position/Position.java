package com.pakie.flymzansi_ato_manager.human_resource.position;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.human_resource.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position extends CommonObject {

    @OneToMany(mappedBy = "position")
    Set<Employee> employees;

    public Position(String title, String description, String details, Long id, Set<Employee> employees) {
        super(title, description, details);
        this.employees = employees;
    }

    public Position() {

    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
