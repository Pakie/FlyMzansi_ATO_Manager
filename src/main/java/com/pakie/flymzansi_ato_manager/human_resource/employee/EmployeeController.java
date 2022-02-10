package com.pakie.flymzansi_ato_manager.human_resource.employee;

import com.pakie.flymzansi_ato_manager.human_resource.department.DepartmentService;
import com.pakie.flymzansi_ato_manager.human_resource.position.PositionService;
import com.pakie.flymzansi_ato_manager.human_resource.employment_type.EmploymentTypeService;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmploymentTypeService employmentTypeService;

    @Autowired
    PositionService positionService;

    @Autowired
    DepartmentService departmentService;

    @Value("${user-image.folder}")
    private String imageFolder;

    @Value("${user-image.size}")
    private Integer imageSize;

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
        model.addAttribute("positions", positionService.getAllPositions());
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "employee/add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,
                               @RequestParam("fileImage") MultipartFile imageFile, RedirectAttributes redirectAttributes) throws IOException {
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());

        employee.setImage(fileName);
        Employee savedEmployee = employeeService.saveEmployee(employee);

        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please choose file to upload.");
            return "employees";
        }

        File file = employeeService.upload(imageFile, employee);
        if(file == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Upload failed.");
            return "employees/add-employee";
        }

        boolean resizeResult =  employeeService.resizeImage(file, employee);
        if(!resizeResult) {
            redirectAttributes.addFlashAttribute("errorMessage", "Resize failed.");
            return "employees/add-employee";
        }

        return "redirect:/employees";
    }

    @GetMapping("/employees/update-employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("employmentTypes", employmentTypeService.getAllEmploymentTypes());
        model.addAttribute("positions", positionService.getAllPositions());
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "employee/update_employee";
    }
    @GetMapping("/employees/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id, Model model){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
