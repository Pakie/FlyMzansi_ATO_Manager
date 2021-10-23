package com.pakie.flymzansi_ato_manager.common_objects.ground_school;

import java.util.List;

public interface GroundSchoolService {
    List<GroundSchool> getAllGroundSchools();
    void saveGroundSchool(GroundSchool groundSchool);
    GroundSchool getGroundSchoolById(Long Id);
    void deleteGroundSchoolById(Long Id);
}
