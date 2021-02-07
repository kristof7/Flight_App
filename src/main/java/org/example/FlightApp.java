package org.example;

import org.example.service.FlightService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FlightApp {
    public static void main(String[] args) {

        LocalDateTime dateInput = LocalDateTime.parse("2018-08-16T06:19:00-02:00", DateTimeFormatter.ISO_DATE_TIME);

        JsonFlightConverter jsonConverter = new JsonFlightConverter();
        FlightService flightDao = new FlightService();
        flightDao.getCargoAndBaggageWeightFromRequestedFlight(5617, dateInput, jsonConverter.readFlightEntityJson());

    }
}