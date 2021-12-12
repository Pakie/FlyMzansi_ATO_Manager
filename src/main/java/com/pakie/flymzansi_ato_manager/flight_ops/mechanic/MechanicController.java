package com.pakie.flymzansi_ato_manager.flight_ops.mechanic;

import com.pakie.flymzansi_ato_manager.flight_ops.license.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
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
                               @RequestParam("fileImage")MultipartFile imageFile, RedirectAttributes redirectAttributes) throws IOException {

        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        mechanic.setImage(fileName);
        Mechanic savedMechanic = mechanicService.saveMechanic(mechanic);

        //The directory will be updated accordingly for production
        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please choose file to upload.");
            return "mechanics/add_mechanic";
        }

        File file = mechanicService.upload(imageFile, mechanic);
        if(file == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Upload failed.");
            return "mechanics/add_mechanic";
        }

        boolean resizeResult =  mechanicService.resizeImage(file, mechanic);
        if(!resizeResult) {
            redirectAttributes.addFlashAttribute("errorMessage", "Resize failed.");
            return "aircraft/add_aircraft";
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
