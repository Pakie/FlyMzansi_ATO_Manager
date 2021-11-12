package com.pakie.flymzansi_ato_manager.human_resource.employment_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentTypeServiceImpl implements EmploymentTypeService {
    @Autowired
    private EmploymentTypeRepo employmentTypeRepo;

    @Override
    public List<EmploymentType> getAllEmploymentTypes() {
        return employmentTypeRepo.findAll();
    }

    @Override
    public void saveEmploymentType(EmploymentType employmentType) {
        this.employmentTypeRepo.save(employmentType);
    }

    @Override
    public EmploymentType getEmploymentTypeById(Long id) {
        Optional<EmploymentType> optional = employmentTypeRepo.findById(id);
        EmploymentType employmentType = null;
        if (optional.isPresent()){
            employmentType = optional.get();
        } else {
            throw new RuntimeException("The employmentType with ID " + id + " does not exist");
        }
        return employmentType;
    }

    @Override
    public void deleteEmploymentTypeById(Long id) {
        this.employmentTypeRepo.deleteById(id);
    }
}
