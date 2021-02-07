package org.example;

import org.example.model.ArrivalAirportIATACode;
import org.example.model.DepartureAirportIATACode;
import org.example.repository.FlightInterface;
import org.example.service.FlightService;

import java.time.LocalDate;


public class FlightApp {
    public static void main(String[] args) {

        LocalDate dateInput = LocalDate.of(2018, 8, 16);

        FlightInterface flightService = new FlightService();

        flightService.getCargoAndBaggageWeightFromRequestedFlight(5617, dateInput);
        flightService.getNumberOfFlightsDepartingFromAirport(DepartureAirportIATACode.YYZ, dateInput);
        flightService.getNumberOfFlightsArrivingToAirport(ArrivalAirportIATACode.LEW, dateInput);
        flightService.getNumberOfBaggagesArrivingToAirport(ArrivalAirportIATACode.LEW, dateInput);
        flightService.getNumberOfBaggagesDepartingFromAirport(DepartureAirportIATACode.YYZ, dateInput);

    }
}