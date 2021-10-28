package com.pakie.flymzansi_ato_manager.person.instructor;

import com.pakie.flymzansi_ato_manager.common_objects.aircraft.AircraftService;
import com.pakie.flymzansi_ato_manager.common_objects.department.DepartmentService;
import com.pakie.flymzansi_ato_manager.common_objects.position.PositionService;
import com.pakie.flymzansi_ato_manager.common_objects.employment_type.EmploymentTypeService;
import com.pakie.flymzansi_ato_manager.common_objects.license.LicenseService;
import com.pakie.flymzansi_ato_manager.common_objects.rating.RatingService;
import com.pakie.flymzansi_ato_manager.person.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String saveInstructor(@ModelAttribute("instructor") Instructor instructor){
        instructorService.saveInstructor(instructor);
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
