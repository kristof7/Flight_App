package org.example;

import org.example.service.FlightService;

import java.time.LocalDate;


public class FlightApp {
    public static void main(String[] args) {

        LocalDate dateInput= LocalDate.of(2018, 8, 16);

        JsonFlightConverter jsonFlightConverter = new JsonFlightConverter();
        FlightService flightService = new FlightService();
        flightService.getCargoAndBaggageWeightFromRequestedFlight(5617, dateInput, jsonFlightConverter.readFlightEntityJson());

//        JsonCargoConverter jsonCargoConverter = new JsonCargoConverter();
//        jsonCargoConverter.readCargoEntityJson();

    }
}