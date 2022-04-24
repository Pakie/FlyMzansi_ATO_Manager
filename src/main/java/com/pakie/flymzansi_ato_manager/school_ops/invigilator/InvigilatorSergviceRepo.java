package com.pakie.flymzansi_ato_manager.school_ops.invigilator;

import com.pakie.flymzansi_ato_manager.school_ops.ground_school.GroundSchool;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;

@Service
public class InvigilatorSergviceRepo implements InvigilatorService {

    @Override
    public List<Invigilator> getAllInvigilators() {
        return null;
    }

    @Override
    public void saveInvigilators(Invigilator invigilator) {

    }

    @Override
    public Invigilator getInvigilatorById(Long Id) {
        return null;
    }

    @Override
    public void deleteInvigilatorById(Long Id) {

    }
}
