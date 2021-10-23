package com.pakie.flymzansi_ato_manager.common_objects.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    //List Departments
    @GetMapping("/departments")
    //public String departments(){
    public String getAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "department/departments";
    }

    @GetMapping("/departments/add-department")
    public String addDepartment(Model model){
        Department department = new Department();
        model.addAttribute("department", department);
        return "department/add_department";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }
    @GetMapping("/departments/update-department/{id}")
    public String updateDepartment(@PathVariable(value = "id") Long id, Model model){
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);

        return "department/update_department";
    }
    @GetMapping("/departments/delete-department/{id}")
    public String deleteDepartment(@PathVariable(value = "id") Long id, Model model){
        this.departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }
}
