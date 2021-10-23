package com.pakie.flymzansi_ato_manager.common_objects.department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(Long Id);
    void deleteDepartmentById(Long Id);
}
