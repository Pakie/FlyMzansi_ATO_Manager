package com.pakie.flymzansi_ato_manager.school_ops.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    @Override
    public void saveSubject(Subject subject) {
        this.subjectRepo.save(subject);
    }

    @Override
    public Subject getSubjectById(Long id) {
        Optional<Subject> optional = subjectRepo.findById(id);
        Subject subject = null;
        if (optional.isPresent()){
            subject = optional.get();
        } else {
            throw new RuntimeException("The subject with ID " + id + " does not exist");
        }
        return subject;
    }

    @Override
    public void deleteSubjectById(Long id) {
        this.subjectRepo.deleteById(id);
    }
}
