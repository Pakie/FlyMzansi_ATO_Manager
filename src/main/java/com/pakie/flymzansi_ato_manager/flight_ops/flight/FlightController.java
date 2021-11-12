package com.pakie.flymzansi_ato_manager.flight_ops.flight;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.AircraftService;
import com.pakie.flymzansi_ato_manager.flight_ops.flight.Flight;
import com.pakie.flymzansi_ato_manager.flight_ops.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;

    @Autowired
    AircraftService aircraftService;

    //List Flights
    @GetMapping("/flights")
    //public String flights(){
    public String getAllFlights(Model model) {
        model.addAttribute("flights", flightService.getAllFlights());
        return "flight/flights";
    }

    @GetMapping("/flights/add-flight")
    public String addFlight(Model model){
        Flight flight = new Flight();
        model.addAttribute("flight", flight);
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());

        return "flight/add_flight";
    }

    @PostMapping("/saveFlight")
    public String saveFlight(@ModelAttribute("flight") Flight flight){
        flightService.saveFlight(flight);
        return "redirect:/flights";
    }
    @GetMapping("/flights/update-flight/{id}")
    public String updateFlight(@PathVariable(value = "id") Long id, Model model){
        Flight flight = flightService.getFlightById(id);
        model.addAttribute("flight", flight);
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());

        return "flight/update_flight";
    }
    @GetMapping("/flights/delete-flight/{id}")
    public String deleteFlight(@PathVariable(value = "id") Long id, Model model){
        this.flightService.deleteFlightById(id);
        return "redirect:/flights";
    }
}
