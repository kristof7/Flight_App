package org.example.repository;

import org.example.model.ArrivalAirportIATACode;
import org.example.model.DepartureAirportIATACode;

import java.time.LocalDate;

public interface FlightInterface {

    void getCargoAndBaggageWeightFromRequestedFlight(Integer flightNumber, LocalDate flightDate);
    void getNumberOfFlightsDepartingFromAirport(DepartureAirportIATACode IATAAirportCode, LocalDate flightDate);
    void getNumberOfFlightsArrivingToAirport(ArrivalAirportIATACode IATAAirportCode, LocalDate flightDate);
    void getNumberOfPiecesOfBaggagesArrivingToAirport(ArrivalAirportIATACode IATAAirportCode, LocalDate flightDate);
    void getNumberOfPiecesOfBaggagesDepartingFromAirport(DepartureAirportIATACode IATAAirportCode, LocalDate flightDate);
}
