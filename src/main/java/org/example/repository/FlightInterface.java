package org.example.repository;

import org.example.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightInterface {
    List<Flight> getCargoAndBaggageWeightFromRequestedFlight(Integer flightNumber, LocalDateTime flightDate, List<Flight> flightList);
}
