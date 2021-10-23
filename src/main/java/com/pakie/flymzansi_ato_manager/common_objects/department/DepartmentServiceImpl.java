package com.pakie.flymzansi_ato_manager.common_objects.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        this.departmentRepo.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> optional = departmentRepo.findById(id);
        Department department = null;
        if (optional.isPresent()){
            department = optional.get();
        } else {
            throw new RuntimeException("The department with ID " + id + " does not exist");
        }
        return department;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        this.departmentRepo.deleteById(id);
    }
}
