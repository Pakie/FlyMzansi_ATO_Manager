package com.pakie.flymzansi_ato_manager.human_resource.department;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.human_resource.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department extends CommonObject {

    @OneToMany(mappedBy = "department")
    Set<Employee> employees;

    public Department(String title, String description, Set<Employee> employees) {
        super(title, description);
        this.employees = employees;
    }

    public Department() {

    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
