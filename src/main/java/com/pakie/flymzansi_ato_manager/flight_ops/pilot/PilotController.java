package com.pakie.flymzansi_ato_manager.flight_ops.pilot;

import com.pakie.flymzansi_ato_manager.flight_ops.license.LicenseService;
import com.pakie.flymzansi_ato_manager.flight_ops.rating.RatingService;
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
public class PilotController {
    @Autowired
    PilotService pilotService;

    @Autowired
    LicenseService licenseService;

    @Autowired
    RatingService ratingService;

    //List Pilots
    @GetMapping("/pilots")
    //public String pilots(){
    public String getAllPilots(Model model) {
        model.addAttribute("pilots", pilotService.getAllPilots());
        return "pilot/pilots";
    }

    @GetMapping("/pilots/add-pilot")
    public String addPilot(Model model){
        Pilot pilot = new Pilot();
        model.addAttribute("pilot", pilot);
        model.addAttribute("licenses", licenseService.getAllLicenses());
        model.addAttribute("ratings", ratingService.getAllRatings());

        return "pilot/add_pilot";
    }

    @PostMapping("/savePilot")
    public String savePilot(@ModelAttribute("pilot") Pilot pilot,
                            @RequestParam("fileImage") MultipartFile imageFile, RedirectAttributes redirectAttributes) throws IOException {
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        pilot.setImage(fileName);
        Pilot savedPilot = pilotService.savePilot(pilot);

        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please choose file to upload.");
            return "pilots/add_pilot";
        }

        File file = pilotService.upload(imageFile, pilot);
        if(file == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Upload failed.");
            return "pilots/add_pilot";
        }

        boolean resizeResult =  pilotService.resizeImage(file, pilot);
        if(!resizeResult) {
            redirectAttributes.addFlashAttribute("errorMessage", "Resize failed.");
            return "pilots/add_pilot";
        }

        return "redirect:/pilots";
    }
    @GetMapping("/pilots/update-pilot/{id}")
    public String updatePilot(@PathVariable(value = "id") Long id, Model model){
        Pilot pilot = pilotService.getPilotById(id);
        model.addAttribute("pilot", pilot);
        model.addAttribute("licenses", licenseService.getAllLicenses());
        model.addAttribute("ratings", ratingService.getAllRatings());

        return "pilot/update_pilot";
    }
    @GetMapping("/pilots/delete-pilot/{id}")
    public String deletePilot(@PathVariable(value = "id") Long id, Model model){
        this.pilotService.deletePilotById(id);
        return "redirect:/pilots";
    }
}
