package com.pakie.flymzansi_ato_manager.common_objects.exam;

import java.util.List;

public interface ExamService {
    List<Exam> getAllExams();
    void saveExam(Exam exam);
    Exam getExamById(Long Id);
    void deleteExamById(Long Id);
}
