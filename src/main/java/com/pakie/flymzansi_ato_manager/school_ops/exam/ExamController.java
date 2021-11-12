package com.pakie.flymzansi_ato_manager.school_ops.exam;

import com.pakie.flymzansi_ato_manager.school_ops.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamController {
    @Autowired
    ExamService examService;

    @Autowired
    SubjectService subjectService;

    //List Exams
    @GetMapping("/courses/subjects/exams")
    //public String exams(){
    public String getAllExams(Model model) {
        model.addAttribute("exams", examService.getAllExams());
        return "course/exam/exams";
    }

    @GetMapping("/courses/subjects/exams/add-exam")
    public String addExam(Model model){
        Exam exam = new Exam();
        model.addAttribute("exam", exam);
        model.addAttribute("subjects", subjectService.getAllSubjects());

        return "course/exam/add_exam";
    }

    @PostMapping("/saveExam")
    public String saveExam(@ModelAttribute("exam") Exam exam){
        examService.saveExam(exam);
        return "redirect:/courses/subjects/exams";
    }
    @GetMapping("/courses/subjects/exams/update-exam/{id}")
    public String updateExam(@PathVariable(value = "id") Long id, Model model){
        Exam exam = examService.getExamById(id);
        model.addAttribute("exam", exam);
        model.addAttribute("subjects", subjectService.getAllSubjects());

        return "course/exam/update_exam";
    }
    @GetMapping("/courses/subjects/exams/delete-exam/{id}")
    public String deleteExam(@PathVariable(value = "id") Long id, Model model){
        this.examService.deleteExamById(id);
        return "redirect:/courses/subjects/exams";
    }
}
