package com.pakie.flymzansi_ato_manager.common_objects.employment_position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmploymentPositionController {
    @Autowired
    EmploymentPositionService employmentPositionService;

    //List EmploymentPositions
    @GetMapping("/employees/employment-positions")
    //public String employmentPositions(){
    public String getAllEmploymentPositions(Model model) {
        model.addAttribute("employmentPositions", employmentPositionService.getAllEmploymentPositions());
        return "employee/employment_position/employment_positions";
    }

    @GetMapping("employees/employment-positions/add-employment-position")
    public String addEmploymentPosition(Model model){
        EmploymentPosition employmentPosition = new EmploymentPosition();
        model.addAttribute("employmentPosition", employmentPosition);
        return "employee/employment_position/add_employment_position";
    }

    @PostMapping("/saveEmploymentPosition")
    public String saveEmploymentPosition(@ModelAttribute("employmentPosition") EmploymentPosition employmentPosition){
        employmentPositionService.saveEmploymentPosition(employmentPosition);
        return "redirect:/employees/employment-positions";
    }
    @GetMapping("employees/employment-positions/update-employment-position/{id}")
    public String updateEmploymentPosition(@PathVariable(value = "id") Long id, Model model){
        EmploymentPosition employmentPosition = employmentPositionService.getEmploymentPositionById(id);
        model.addAttribute("employmentPosition", employmentPosition);

        return "employee/employment_position/update_employment_position";
    }
    @GetMapping("employees/employment-positions/delete-employment-position/{id}")
    public String deleteEmploymentPosition(@PathVariable(value = "id") Long id, Model model){
        this.employmentPositionService.deleteEmploymentPositionById(id);
        return "redirect:/employees/employment-positions";
    }
}
