package com.pakie.flymzansi_ato_manager.school_ops.student;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.AircraftService;
import com.pakie.flymzansi_ato_manager.school_ops.course.CourseService;
import com.pakie.flymzansi_ato_manager.flight_ops.license.LicenseService;
import com.pakie.flymzansi_ato_manager.flight_ops.rating.RatingService;
import com.pakie.flymzansi_ato_manager.school_ops.instructor.InstructorService;
import com.pakie.flymzansi_ato_manager.school_ops.sponsor.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

    @Value("${user-image.folder}")
    private String imageFolder;

    @Value("${user-image.size}")
    private Integer imageSize;

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
    public String saveStudent(@ModelAttribute("student") Student student,
                              @RequestParam("fileImage") MultipartFile imageFile, RedirectAttributes redirectAttributes) throws IOException {
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        student.setImage(fileName);
        Student savedStudent = studentService.saveStudent(student);

        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please choose file to upload.");
            return "employees/add_employee";
        }

        File file = studentService.upload(imageFile, student);
        if(file == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Upload failed.");
            return "employees/add_employee";
        }

        boolean resizeResult =  studentService.resizeImage(file, student);
        if(!resizeResult) {
            redirectAttributes.addFlashAttribute("errorMessage", "Resize failed.");
            return "employees/add_employee";
        }

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
