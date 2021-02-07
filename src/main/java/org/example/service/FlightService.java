package org.example.service;

import org.example.model.Flight;
import org.example.repository.FlightInterface;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService implements FlightInterface {

    @Override
    public List<Flight> getCargoAndBaggageWeightFromRequestedFlight(Integer flightNumber, LocalDateTime flightDate, List<Flight> flightList) {
        List<Flight> result = flightList.stream()
                .filter(flight -> flight.getFlightNumber().equals(flightNumber))
                .filter(flight -> flight.getDepartureDate().equals(flightDate))
                .collect(Collectors.toList());
        for (Flight f : result) {
            System.out.println("Test output");
//            System.out.println("For requested Flight Number and date: \n");
//            System.out.println("Cargo Weight for requested Flight: " + f.getFlightNumber().intValue());
//            System.out.println("Baggage Weight for requested Flight: " + f.getFlightNumber().intValue());
//            System.out.println("Total Weight for requested Flight: " + f.getFlightNumber().intValue());
        }
        return result;
    }
}
