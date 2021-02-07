package org.example;

import org.example.model.FlightEntity;
import org.example.repository.FlightInterface;
import org.example.service.FlightService;

import java.time.LocalDate;
import java.util.List;


public class FlightApp {
    public static void main(String[] args) {

        LocalDate dateInput = LocalDate.of(2018, 8, 16);

        FlightInterface flightService = new FlightService();

        flightService.getCargoAndBaggageWeightFromRequestedFlight(5617, dateInput);

    }

    public static void getData2(String IATAAirportCode, LocalDate flightDate, List<FlightEntity> flightList, List<FlightEntity> cargoList) {

        System.out.println(IATAAirportCode + " " + flightDate + " " + flightList + " " + cargoList);

    }
}