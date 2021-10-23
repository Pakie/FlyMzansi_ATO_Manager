package com.pakie.flymzansi_ato_manager.common_objects.exam;

import com.pakie.flymzansi_ato_manager.common_objects.exam.Exam;
import com.pakie.flymzansi_ato_manager.common_objects.exam.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepo examRepo;

    @Override
    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }

    @Override
    public void saveExam(Exam exam) {
        this.examRepo.save(exam);
    }

    @Override
    public Exam getExamById(Long id) {
        Optional<Exam> optional = examRepo.findById(id);
        Exam exam = null;
        if (optional.isPresent()){
            exam = optional.get();
        } else {
            throw new RuntimeException("The exam with ID " + id + " does not exist");
        }
        return exam;
    }

    @Override
    public void deleteExamById(Long id) {
        this.examRepo.deleteById(id);
    }
}
