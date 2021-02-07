package org.example.repository;

import java.time.LocalDate;

public interface FlightInterface {

    void getCargoAndBaggageWeightFromRequestedFlight(Integer flightNumber, LocalDate flightDate);
}
