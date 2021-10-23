package com.pakie.flymzansi_ato_manager.common_objects.employment_position;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentPositionServiceImpl implements EmploymentPositionService {
    @Autowired
    private EmploymentPositionRepo employmentPositionRepo;

    @Override
    public List<EmploymentPosition> getAllEmploymentPositions() {
        return employmentPositionRepo.findAll();
    }

    @Override
    public void saveEmploymentPosition(EmploymentPosition employmentPosition) {
        this.employmentPositionRepo.save(employmentPosition);
    }

    @Override
    public EmploymentPosition getEmploymentPositionById(Long id) {
        Optional<EmploymentPosition> optional = employmentPositionRepo.findById(id);
        EmploymentPosition employmentPosition = null;
        if (optional.isPresent()){
            employmentPosition = optional.get();
        } else {
            throw new RuntimeException("The employmentPosition with ID " + id + " does not exist");
        }
        return employmentPosition;
    }

    @Override
    public void deleteEmploymentPositionById(Long id) {
        this.employmentPositionRepo.deleteById(id);
    }
}
