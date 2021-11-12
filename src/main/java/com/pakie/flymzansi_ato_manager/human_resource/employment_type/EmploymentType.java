package com.pakie.flymzansi_ato_manager.human_resource.employment_type;

import com.pakie.flymzansi_ato_manager.common_objects.CommonObject;
import com.pakie.flymzansi_ato_manager.human_resource.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employment_type")
public class EmploymentType extends CommonObject {

    @OneToMany(mappedBy = "employmentType")
    Set<Employee> employees;

    public EmploymentType(String title, String description, String details, Set<Employee> employees) {
        super(title, description, details);
        this.employees = employees;
    }

    public EmploymentType() {

    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
