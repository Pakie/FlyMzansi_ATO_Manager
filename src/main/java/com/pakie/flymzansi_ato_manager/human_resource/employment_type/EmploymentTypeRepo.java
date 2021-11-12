package com.pakie.flymzansi_ato_manager.human_resource.employment_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentTypeRepo extends JpaRepository<EmploymentType, Long> {

}
