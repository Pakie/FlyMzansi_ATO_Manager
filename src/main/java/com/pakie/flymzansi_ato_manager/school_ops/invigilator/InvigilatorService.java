package com.pakie.flymzansi_ato_manager.school_ops.invigilator;

import com.pakie.flymzansi_ato_manager.school_ops.ground_school.GroundSchool;

import java.util.List;

public interface InvigilatorService {
    List<Invigilator> getAllInvigilators();
    void saveInvigilators(Invigilator invigilator);
    Invigilator getInvigilatorById(Long Id);
    void deleteInvigilatorById(Long Id);
}
