package com.pakie.flymzansi_ato_manager.human_resource.employee;

import com.pakie.flymzansi_ato_manager.human_resource.department.DepartmentService;
import com.pakie.flymzansi_ato_manager.human_resource.position.PositionService;
import com.pakie.flymzansi_ato_manager.human_resource.employment_type.EmploymentTypeService;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
                               @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        employee.setImage(fileName);
        Employee savedEmployee = employeeService.saveEmployee(employee);

        //The directory will be updated accordingly for production
        String uploadDir = "./src/main/resources/static/global_assets/images/uploads/user/" + savedEmployee.getEmail();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName);
            System.out.println(filePath.toString());

            /*BufferedImage fileImage = ImageIO.read(inputStream);
            //if (fileImage == null) { System.err.println("NO SOURCE IMAGE!"); }
            BufferedImage newImage = new BufferedImage(int 400,);

            BufferedImage simpleResizeImage(BufferedImage originalImage, int targetWidth) throws Exception {
                return Scalr.resize(originalImage, targetWidth);
            }*/

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new IOException("Oops! Failed to upload file " + fileName);
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
