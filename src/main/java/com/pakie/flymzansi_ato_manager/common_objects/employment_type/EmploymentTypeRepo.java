package com.pakie.flymzansi_ato_manager.common_objects.employment_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentTypeRepo extends JpaRepository<EmploymentType, Long> {

}
