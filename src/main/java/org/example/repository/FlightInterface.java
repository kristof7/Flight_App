package org.example.repository;

import org.example.model.DepartureAirportIATACode;

import java.time.LocalDate;

public interface FlightInterface {

    void getCargoAndBaggageWeightFromRequestedFlight(Integer flightNumber, LocalDate flightDate);
    void getNumberOfFlightsDepartingFromAirport(DepartureAirportIATACode IATAAirportCode, LocalDate flightDate);
    void getNumberOfFlightsArrivingToAirport(String IATAAirportCode, LocalDate flightDate);
}
