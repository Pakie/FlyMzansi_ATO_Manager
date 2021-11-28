package com.pakie.flymzansi_ato_manager.flight_ops.pilot;

import com.pakie.flymzansi_ato_manager.flight_ops.license.LicenseService;
import com.pakie.flymzansi_ato_manager.flight_ops.rating.RatingService;
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
                            @RequestParam("imageFile") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        pilot.setImage(fileName);
        Pilot savedPilot = pilotService.savePilot(pilot);

        //The directory will be updated accordingly for production
        String uploadDir = "./src/main/resources/static/global_assets/images/uploads/user/" + savedPilot.getEmail();

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
