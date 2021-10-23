package com.pakie.flymzansi_ato_manager.common_objects.aircraft_maintenance;

import com.pakie.flymzansi_ato_manager.common_objects.aircraft.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AircraftMaintenanceController {
    @Autowired
    AircraftMaintenanceService aircraftMaintenanceService;

    @Autowired
    AircraftService aircraftService;

    //List AircraftMaintenances
    @GetMapping("/aircrafts/aircraft-maintenances")
    //public String aircraftMaintenances(){
    public String getAllAircraftMaintenances(Model model) {
        model.addAttribute("aircraftMaintenances", aircraftMaintenanceService.getAllAircraftMaintenances());
        return "aircraft/aircraft_maintenance/aircraft_maintenances";
    }

    @GetMapping("/aircrafts/aircraft-maintenances/add-aircraft-maintenance")
    public String addAircraftMaintenance(Model model){
        AircraftMaintenance aircraftMaintenance = new AircraftMaintenance();
        model.addAttribute("aircraftMaintenance", aircraftMaintenance);
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());

        return "aircraft/aircraft_maintenance/add_aircraft_maintenance";
    }

    @PostMapping("/saveAircraftMaintenance")
    public String saveAircraftMaintenance(@ModelAttribute("aircraftMaintenance") AircraftMaintenance aircraftMaintenance){
        aircraftMaintenanceService.saveAircraftMaintenance(aircraftMaintenance);
        return "redirect:/aircraft_maintenances";
    }
    @GetMapping("/aircrafts/aircraft-maintenances/update-aircraft-maintenance/{id}")
    public String updateAircraftMaintenance(@PathVariable(value = "id") Long id, Model model){
        AircraftMaintenance aircraftMaintenance = aircraftMaintenanceService.getAircraftMaintenanceById(id);
        model.addAttribute("aircraftMaintenance", aircraftMaintenance);
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());

        return "aircraft/aircraft_maintenance/update_aircraft_maintenance";
    }
    @GetMapping("/aircrafts/aircraft-maintenances/delete-aircraft-maintenance/{id}")
    public String deleteAircraftMaintenance(@PathVariable(value = "id") Long id, Model model){
        this.aircraftMaintenanceService.deleteAircraftMaintenanceById(id);
        return "redirect:/aircraft_maintenances";
    }
}
