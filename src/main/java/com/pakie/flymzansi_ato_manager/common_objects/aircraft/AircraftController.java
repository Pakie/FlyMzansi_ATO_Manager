package com.pakie.flymzansi_ato_manager.common_objects.aircraft;

import com.pakie.flymzansi_ato_manager.common_objects.aircraft_type.AircraftTypeController;
import com.pakie.flymzansi_ato_manager.common_objects.aircraft_type.AircraftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AircraftController {
    @Autowired
    AircraftService aircraftService;

    @Autowired
    AircraftTypeService aircraftTypeService;

    //List Aircrafts
    @GetMapping("/aircrafts")
    //public String aircrafts(){
    public String getAllAircrafts(Model model) {
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());
        return "aircraft/aircrafts";
    }

    @GetMapping("/aircrafts/add-aircraft")
    public String addAircraft(Model model){
        Aircraft aircraft = new Aircraft();
        model.addAttribute("aircraft", aircraft);
        model.addAttribute("aircraftTypes", aircraftTypeService.getAllAircraftTypes());
        return "aircraft/add_aircraft";
    }

    @PostMapping("/saveAircraft")
    public String saveAircraft(@ModelAttribute("aircraft") Aircraft aircraft){
        aircraftService.saveAircraft(aircraft);
        return "redirect:/aircrafts";
    }
    @GetMapping("/aircrafts/update-aircraft/{id}")
    public String updateAircraft(@PathVariable(value = "id") Long id, Model model){
        Aircraft aircraft = aircraftService.getAircraftById(id);
        model.addAttribute("aircraft", aircraft);
        model.addAttribute("aircraftTypes", aircraftTypeService.getAllAircraftTypes());

        return "aircraft/update_aircraft";
    }
    @GetMapping("/aircrafts/delete-aircraft/{id}")
    public String deleteAircraft(@PathVariable(value = "id") Long id, Model model){
        this.aircraftService.deleteAircraftById(id);
        return "redirect:/aircrafts";
    }
}
