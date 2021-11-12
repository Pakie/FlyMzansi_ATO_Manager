package com.pakie.flymzansi_ato_manager.school_ops.exam;

import java.util.List;

public interface ExamService {
    List<Exam> getAllExams();
    void saveExam(Exam exam);
    Exam getExamById(Long Id);
    void deleteExamById(Long Id);
}
