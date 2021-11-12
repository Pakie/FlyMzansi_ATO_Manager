package com.pakie.flymzansi_ato_manager.human_resource.employment_type;

import java.util.List;

public interface EmploymentTypeService {
    List<EmploymentType> getAllEmploymentTypes();
    void saveEmploymentType(EmploymentType employmentType);
    EmploymentType getEmploymentTypeById(Long Id);
    void deleteEmploymentTypeById(Long Id);
}
