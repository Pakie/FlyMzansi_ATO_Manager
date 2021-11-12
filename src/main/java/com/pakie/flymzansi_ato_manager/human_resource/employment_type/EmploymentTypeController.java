package com.pakie.flymzansi_ato_manager.human_resource.employment_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmploymentTypeController {
    @Autowired
    EmploymentTypeService employmentTypeService;

    //List EmploymentTypes
    @GetMapping("/employees/employment-types")
    //public String employmentTypes(){
    public String getAllEmploymentTypes(Model model) {
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());
        return "employee/employment_type/employment_types";
    }

    @GetMapping("employees/employment-types/add-employment-type")
    public String addEmploymentType(Model model){
        EmploymentType employmentType = new EmploymentType();
        model.addAttribute("employmentType", employmentType);
        return "employee/employment_type/add_employment_type";
    }

    @PostMapping("/saveEmploymentType")
    public String saveEmploymentType(@ModelAttribute("employmentType") EmploymentType employmentType){
        employmentTypeService.saveEmploymentType(employmentType);
        return "redirect:/employees/employment-types";
    }
    @GetMapping("employees/employment-types/update-employment-type/{id}")
    public String updateEmploymentType(@PathVariable(value = "id") Long id, Model model){
        EmploymentType employmentType = employmentTypeService.getEmploymentTypeById(id);
        model.addAttribute("employmentType", employmentType);

        return "employee/employment_type/update_employment_type";
    }
    @GetMapping("employees/employment-types/delete-employment-type/{id}")
    public String deleteEmploymentType(@PathVariable(value = "id") Long id, Model model){
        this.employmentTypeService.deleteEmploymentTypeById(id);
        return "redirect:/employees/employment-types";
    }
}
