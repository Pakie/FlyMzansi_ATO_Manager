package com.pakie.flymzansi_ato_manager.common_objects.employment_position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentPositionRepo extends JpaRepository<EmploymentPosition, Long> {

}
