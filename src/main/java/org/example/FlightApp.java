package org.example;

import org.example.model.ArrivalAirportIATACode;
import org.example.model.DepartureAirportIATACode;
import org.example.repository.FlightInterface;
import org.example.service.FlightService;

import java.time.LocalDate;


public class FlightApp {
    public static void main(String[] args) {

        LocalDate dapartureDate = LocalDate.of(2018, 8, 16);
        LocalDate arrivalDate = LocalDate.of(2018, 8, 23);

        FlightInterface flightService = new FlightService();

        flightService.getCargoAndBaggageWeightFromRequestedFlight(5617, dapartureDate);
        flightService.getCargoWeightForRequestedFlight(5617, dapartureDate);
        flightService.getBaggageWeightForRequestedFlight(5617, dapartureDate);
        flightService.getTotalWeightForRequestedFlight(5617, dapartureDate);
        flightService.getNumberOfFlightsDepartingFromAirport(DepartureAirportIATACode.YYZ, dapartureDate);
        flightService.getNumberOfFlightsArrivingToAirport(ArrivalAirportIATACode.LEW, arrivalDate);
        flightService.getNumberOfPiecesOfBaggagesArrivingToAirport(ArrivalAirportIATACode.LEW, arrivalDate);
        flightService.getNumberOfPiecesOfBaggagesDepartingFromAirport(DepartureAirportIATACode.YYZ, dapartureDate);

    }
}