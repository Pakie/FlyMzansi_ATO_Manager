package com.pakie.flymzansi_ato_manager.person.student;

import com.pakie.flymzansi_ato_manager.common_objects.aircraft.AircraftService;
import com.pakie.flymzansi_ato_manager.common_objects.course.CourseService;
import com.pakie.flymzansi_ato_manager.common_objects.department.DepartmentService;
import com.pakie.flymzansi_ato_manager.common_objects.license.LicenseService;
import com.pakie.flymzansi_ato_manager.common_objects.rating.RatingService;
import com.pakie.flymzansi_ato_manager.person.instructor.InstructorService;
import com.pakie.flymzansi_ato_manager.person.sponsor.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    LicenseService licenseService;

    @Autowired
    AircraftService aircraftService;

    @Autowired
    RatingService ratingService;

    @Autowired
    SponsorService sponsorService;

    @Autowired
    InstructorService instructorService;

    //List Students
    @GetMapping("/students")
    //public String students(){
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/students";
    }

    @GetMapping("/students/add-student")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("licenses", licenseService.getAllLicenses());
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());
        model.addAttribute("ratings", ratingService.getAllRatings());
        model.addAttribute("sponsors", sponsorService.getAllSponsors());
        model.addAttribute("instructors", instructorService.getAllInstructors());

        return "student/add_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/update-student/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("licenses", licenseService.getAllLicenses());
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());
        model.addAttribute("ratings", ratingService.getAllRatings());
        model.addAttribute("sponsors", sponsorService.getAllSponsors());
        model.addAttribute("instructors", instructorService.getAllInstructors());

        return "student/update_student";
    }
    @GetMapping("/students/delete-student/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id, Model model){
        this.studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
