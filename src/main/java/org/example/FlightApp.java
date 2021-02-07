package org.example;

import org.example.model.Flight;
import org.example.service.FlightService;

import java.time.LocalDate;
import java.util.List;


public class FlightApp {
    public static void main(String[] args) {

        LocalDate dateInput = LocalDate.of(2018, 8, 16);

        JsonFlightConverter jsonFlightConverter = new JsonFlightConverter();
        FlightService flightService = new FlightService();
        List<Flight> flightList = jsonFlightConverter.readFlightEntityJson();
        flightService.getCargoAndBaggageWeightFromRequestedFlight(5617, dateInput, flightList);

//        JsonCargoConverter jsonCargoConverter = new JsonCargoConverter();
//        jsonCargoConverter.readCargoEntityJson();

        getData2("YYZ", dateInput, flightList, null);

    }

    public static void getData2(String IATAAirportCode, LocalDate flightDate, List<Flight> flightList, List<Flight> cargoList) {

//        System.out.println(IATAAirportCode + " " + flightDate + " " + flightList + " " + cargoList);

    }
}