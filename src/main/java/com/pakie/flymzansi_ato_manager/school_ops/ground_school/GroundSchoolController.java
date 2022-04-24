package com.pakie.flymzansi_ato_manager.school_ops.ground_school;

import com.pakie.flymzansi_ato_manager.common_objects.room.RoomService;
import com.pakie.flymzansi_ato_manager.school_ops.exam.Exam;
import com.pakie.flymzansi_ato_manager.school_ops.subject.SubjectService;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroundSchoolController {
    @Autowired
    GroundSchoolService groundSchoolService;

    @Autowired
    RoomService roomService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    InstructorService instructorService;

    //List GroundSchools
    @GetMapping("/ground-schools")
    //public String groundSchools(){
    public String getAllGroundSchools(Model model) {
        model.addAttribute("groundSchools", groundSchoolService.getAllGroundSchools());
        return "ground_school/ground_schools";
    }

    @GetMapping("/ground-schools/add-ground-school")
    public String addGroundSchool(Model model){
        GroundSchool groundSchool = new GroundSchool();
        model.addAttribute("groundSchool", groundSchool);
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("instructors", instructorService.getAllInstructors());

        return "ground_school/add_ground_school";
    }

    @PostMapping("/saveGroundSchool")
    public String saveGroundSchool(@ModelAttribute("exam") GroundSchool groundSchool){
        groundSchoolService.saveGroundSchool(groundSchool);
        return "redirect:/ground-schools";
    }

    @GetMapping("/ground-schools/update-ground-school/{id}")
    public String updateGroundSchool(@PathVariable(value = "id") Long id, Model model){
        GroundSchool groundSchool = groundSchoolService.getGroundSchoolById(id);
        model.addAttribute("groundSchool", groundSchool);
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("instructors", instructorService.getAllInstructors());

        return "ground_school/update_ground_school";
    }
    @GetMapping("/ground-schools/delete-ground-school/{id}")
    public String deleteGroundSchool(@PathVariable(value = "id") Long id, Model model){
        this.groundSchoolService.deleteGroundSchoolById(id);
        return "redirect:/ground-schools";
    }
}
