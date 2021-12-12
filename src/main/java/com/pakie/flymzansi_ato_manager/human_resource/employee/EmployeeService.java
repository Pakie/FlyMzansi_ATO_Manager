package com.pakie.flymzansi_ato_manager.human_resource.employee;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    File upload(MultipartFile imageFile, Employee employee) throws IOException;
    boolean resizeImage(File sourceFile, Employee employee);
    Employee getEmployeeById(Long Id);
    void deleteEmployeeById(Long Id);
}
