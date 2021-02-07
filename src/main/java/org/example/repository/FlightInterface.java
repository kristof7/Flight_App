package org.example.repository;

import org.example.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightInterface {
    List<Flight> getCargoAndBaggageWeightFromRequestedFlight(Integer flightNumber, LocalDate flightDate, List<Flight> flightList);


}
