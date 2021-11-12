package com.pakie.flymzansi_ato_manager.flight_ops.aircraft_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AircraftTypeController {
    @Autowired
    AircraftTypeService aircraftTypeService;

    //List AircraftTypes
    @GetMapping("/aircrafts/aircraft-types")
    //public String aircraftTypes(){
    public String getAllAircraftTypes(Model model) {
        model.addAttribute("aircraftTypes", aircraftTypeService.getAllAircraftTypes());
        return "aircraft/aircraft_type/aircraft_types";
    }

    @GetMapping("/aircrafts/aircraft-types/add-aircraft-type")
    public String addAircraftType(Model model){
        AircraftType aircraftType = new AircraftType();
        model.addAttribute("aircraftType", aircraftType);
        return "aircraft/aircraft_type/add_aircraft_type";
    }

    @PostMapping("/saveAircraftType")
    public String saveAircraftType(@ModelAttribute("aircraftType") AircraftType aircraftType){
        aircraftTypeService.saveAircraftType(aircraftType);
        return "redirect:/aircrafts/aircraft-types";
    }
    @GetMapping("/aircrafts/aircraft-types/update-aircraft-type/{id}")
    public String updateAircraftType(@PathVariable(value = "id") Long id, Model model){
        AircraftType aircraftType = aircraftTypeService.getAircraftTypeById(id);
        model.addAttribute("aircraftType", aircraftType);

        return "aircraft/aircraft_type/update_aircraft_type";
    }
    @GetMapping("/aircrafts/aircraft-types/delete-aircraft-ype/{id}")
    public String deleteAircraftType(@PathVariable(value = "id") Long id, Model model){
        this.aircraftTypeService.deleteAircraftTypeById(id);
        return "redirect:/aircrafts/aircraft-types";
    }
}
