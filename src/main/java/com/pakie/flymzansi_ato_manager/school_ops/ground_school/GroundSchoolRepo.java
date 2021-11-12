package com.pakie.flymzansi_ato_manager.school_ops.ground_school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundSchoolRepo extends JpaRepository<GroundSchool, Long> {

}
