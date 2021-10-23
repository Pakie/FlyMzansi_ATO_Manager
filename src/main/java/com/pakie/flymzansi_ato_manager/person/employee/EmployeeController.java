package com.pakie.flymzansi_ato_manager.person.employee;

import com.pakie.flymzansi_ato_manager.common_objects.department.DepartmentService;
import com.pakie.flymzansi_ato_manager.common_objects.employment_position.EmploymentPositionService;
import com.pakie.flymzansi_ato_manager.common_objects.employment_type.EmploymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmploymentTypeService employmentTypeService;

    @Autowired
    EmploymentPositionService employmentPositionService;

    @Autowired
    DepartmentService departmentService;

    //List Employees
    @GetMapping("/employees")
    //public String employees(){
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/employees";
    }

    @GetMapping("/employees/add-employee")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());
        model.addAttribute("employmentPositions", employmentPositionService.getAllEmploymentPositions());
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "employee/add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/update-employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());
        model.addAttribute("employmentPositions", employmentPositionService.getAllEmploymentPositions());
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "employee/update_employee";
    }
    @GetMapping("/employees/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id, Model model){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
