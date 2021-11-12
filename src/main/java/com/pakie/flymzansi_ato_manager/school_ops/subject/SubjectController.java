package com.pakie.flymzansi_ato_manager.school_ops.subject;

import com.pakie.flymzansi_ato_manager.school_ops.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    CourseService courseService;

    //List Subjects
    @GetMapping("/courses/subjects")
    //public String subjects(){
    public String getAllSubjects(Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "course/subject/subjects";
    }

    @GetMapping("/courses/subjects/add-subject")
    public String addSubject(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        model.addAttribute("courses", courseService.getAllCourses());

        return "course/subject/add_subject";
    }

    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute("subject") Subject subject){
        subjectService.saveSubject(subject);
        return "redirect:/courses/subjects";
    }
    @GetMapping("/courses/subjects/update-subject/{id}")
    public String updateSubject(@PathVariable(value = "id") Long id, Model model){
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        model.addAttribute("courses", courseService.getAllCourses());

        return "course/subject/update_subject";
    }
    @GetMapping("/courses/subjects/delete-subject/{id}")
    public String deleteSubject(@PathVariable(value = "id") Long id, Model model){
        this.subjectService.deleteSubjectById(id);
        return "redirect:/courses/subjects";
    }
}
