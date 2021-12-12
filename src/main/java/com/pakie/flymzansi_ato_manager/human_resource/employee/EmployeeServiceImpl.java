package com.pakie.flymzansi_ato_manager.human_resource.employee;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.AircraftServiceImpl;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Value("${user-image.folder}")
    private String imageFolder;

    @Value("${user-image.size}")
    private Integer imageSize;

    private Logger logger = LoggerFactory.getLogger(AircraftServiceImpl.class);

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);
        return employee;
    }

    @Override
    public File upload(MultipartFile imageFile, Employee employee) throws IOException {
        try {
            String savedEmployee = employee.getEmail();
            String uploadDir = imageFolder + savedEmployee;
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path path = Paths.get(uploadDir, imageFile.getOriginalFilename());
            Files.write(path, imageFile.getBytes());
            return path.toFile();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public boolean resizeImage(File sourceFile, Employee employee) {
        try {
            String savedEmployee = employee.getEmail();
            String uploadDir = imageFolder + savedEmployee;
            BufferedImage bufferedImage = ImageIO.read(sourceFile);
            BufferedImage outputImage = Scalr.resize(bufferedImage, imageSize);
            String newFileName = sourceFile.getName();
            //String newFileName = FilenameUtils.getBaseName(sourceFile.getName())
            //       + "." + FilenameUtils.getExtension(sourceFile.getName());
            // + "_" + imageSize.toString() + "."

            Path path = Paths.get(uploadDir,newFileName);
            File newImageFile = path.toFile();
            ImageIO.write(outputImage, "jpg", newImageFile);
            outputImage.flush();
            //sourceFile.delete();

            return true;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent()){
            employee = optional.get();
        } else {
            throw new RuntimeException("The employee with ID " + id + " does not exist");
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepo.deleteById(id);
    }
}
