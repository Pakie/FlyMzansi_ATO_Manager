package com.pakie.flymzansi_ato_manager.flight_ops.flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
    void saveFlight(Flight flight);
    Flight getFlightById(Long Id);
    void deleteFlightById(Long Id);
}
