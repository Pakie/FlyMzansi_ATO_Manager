package com.pakie.flymzansi_ato_manager.common_objects.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepo flightRepo;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @Override
    public void saveFlight(Flight flight) {
        this.flightRepo.save(flight);
    }

    @Override
    public Flight getFlightById(Long id) {
        Optional<Flight> optional = flightRepo.findById(id);
        Flight flight = null;
        if (optional.isPresent()){
            flight = optional.get();
        } else {
            throw new RuntimeException("The flight with ID " + id + " does not exist");
        }
        return flight;
    }

    @Override
    public void deleteFlightById(Long id) {
        this.flightRepo.deleteById(id);
    }
}
