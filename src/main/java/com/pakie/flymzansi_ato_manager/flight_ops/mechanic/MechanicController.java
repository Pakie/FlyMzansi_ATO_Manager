package com.pakie.flymzansi_ato_manager.flight_ops.mechanic;

import com.pakie.flymzansi_ato_manager.flight_ops.license.LicenseService;
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
public class MechanicController {
    @Autowired
    MechanicService mechanicService;

    @Autowired
    LicenseService licenseService;

    //List Mechanics
    @GetMapping("/mechanics")
    //public String mechanics(){
    public String getAllMechanics(Model model) {
        model.addAttribute("mechanics", mechanicService.getAllMechanics());
        return "mechanic/mechanics";
    }

    @GetMapping("/mechanics/add-mechanic")
    public String addMechanic(Model model){
        Mechanic mechanic = new Mechanic();
        model.addAttribute("mechanic", mechanic);
        model.addAttribute("licenses", licenseService.getAllLicenses());

        return "mechanic/add_mechanic";
    }

    @PostMapping("/saveMechanic")
    public String saveMechanic(@ModelAttribute("mechanic") Mechanic mechanic,
                               @RequestParam("imageFile")MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        mechanic.setImage(fileName);
        Mechanic savedMechanic = mechanicService.saveMechanic(mechanic);

        //The directory will be updated accordingly for production
        String uploadDir = "./src/main/resources/static/global_assets/images/uploads/user/" + savedMechanic.getEmail();

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

        return "redirect:/mechanics";
    }
    @GetMapping("/mechanics/update-mechanic/{id}")
    public String updateMechanic(@PathVariable(value = "id") Long id, Model model){
        Mechanic mechanic = mechanicService.getMechanicById(id);
        model.addAttribute("mechanic", mechanic);
        model.addAttribute("licenses", licenseService.getAllLicenses());

        return "mechanic/update_mechanic";
    }
    @GetMapping("/mechanics/delete-mechanic/{id}")
    public String deleteMechanic(@PathVariable(value = "id") Long id, Model model){
        this.mechanicService.deleteMechanicById(id);
        return "redirect:/mechanics";
    }
}
