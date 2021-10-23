package com.pakie.flymzansi_ato_manager.person.mechanic;

import com.pakie.flymzansi_ato_manager.common_objects.license.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String saveMechanic(@ModelAttribute("mechanic") Mechanic mechanic){
        mechanicService.saveMechanic(mechanic);
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
