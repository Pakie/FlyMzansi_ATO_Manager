package com.pakie.flymzansi_ato_manager.school_ops.instructor;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.AircraftService;
import com.pakie.flymzansi_ato_manager.human_resource.department.DepartmentService;
import com.pakie.flymzansi_ato_manager.human_resource.position.PositionService;
import com.pakie.flymzansi_ato_manager.human_resource.employment_type.EmploymentTypeService;
import com.pakie.flymzansi_ato_manager.flight_ops.license.LicenseService;
import com.pakie.flymzansi_ato_manager.flight_ops.rating.RatingService;
import com.pakie.flymzansi_ato_manager.human_resource.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AircraftService aircraftService;

    @Autowired
    RatingService ratingService;

    @Autowired
    LicenseService licenseService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    PositionService employmentPositionService;

    @Autowired
    EmploymentTypeService employmentTypeService;

    //List Instructors
    @GetMapping("employees/instructors")
    //public String instructors(){
    public String getAllInstructors(Model model) {
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "instructor/instructors";
    }

    @GetMapping("employees/instructors/add-instructor")
    public String addInstructor(Model model){
        Instructor instructor = new Instructor();
        model.addAttribute("instructor", instructor);
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());
        model.addAttribute("ratings", ratingService.getAllRatings());
        model.addAttribute("licenses", licenseService.getAllLicenses());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("positions", employmentPositionService.getAllPositions());
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());

        return "instructor/add_instructor";
    }

    @PostMapping("/saveInstructor")
    public String saveInstructor(@ModelAttribute("instructor") Instructor instructor,
                                 @RequestParam("fileImage")MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        instructor.setImage(fileName);
        Instructor savedInstructor = instructorService.saveInstructor(instructor);

        instructorService.saveInstructor(instructor);

        //The directory will be updated accordingly for production
        String uploadDir = "./src/main/resources/static/global_assets/images/uploads/user/" + savedInstructor.getEmail();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName);
            System.out.println(filePath.toString());

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Oops! Failed to upload file " + fileName);
        }

        return "redirect:/employees/instructors";
    }
    @GetMapping("/employees/instructors/update-instructor/{id}")
    public String updateInstructor(@PathVariable(value = "id") Long id, Model model){
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("instructor", instructor);
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());
        model.addAttribute("licenses", licenseService.getAllLicenses());
        model.addAttribute("ratings", ratingService.getAllRatings());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("positions", employmentPositionService.getAllPositions());
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());

        return "instructor/update_instructor";
    }
    @GetMapping("/employees/instructors/delete-instructor/{id}")
    public String deleteInstructor(@PathVariable(value = "id") Long id, Model model){
        this.instructorService.deleteInstructorById(id);
        return "redirect:/employees/instructors";
    }
}