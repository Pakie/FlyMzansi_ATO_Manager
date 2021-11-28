package com.pakie.flymzansi_ato_manager.human_resource.employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long Id);
    void deleteEmployeeById(Long Id);
}
