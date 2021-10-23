package com.pakie.flymzansi_ato_manager.common_objects.employment_position;

import java.util.List;

public interface EmploymentPositionService {
    List<EmploymentPosition> getAllEmploymentPositions();
    void saveEmploymentPosition(EmploymentPosition employmentPosition);
    EmploymentPosition getEmploymentPositionById(Long Id);
    void deleteEmploymentPositionById(Long Id);
}
