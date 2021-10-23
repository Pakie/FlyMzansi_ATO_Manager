package com.pakie.flymzansi_ato_manager.common_objects.subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    void saveSubject(Subject subject);
    Subject getSubjectById(Long Id);
    void deleteSubjectById(Long Id);
}
