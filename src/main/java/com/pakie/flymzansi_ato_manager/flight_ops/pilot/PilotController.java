package com.pakie.flymzansi_ato_manager.flight_ops.pilot;

import com.pakie.flymzansi_ato_manager.flight_ops.license.LicenseService;
import com.pakie.flymzansi_ato_manager.flight_ops.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String savePilot(@ModelAttribute("pilot") Pilot pilot){
        pilotService.savePilot(pilot);
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
