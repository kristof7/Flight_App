package org.example.service;

import org.example.JsonContainerEntityConverter;
import org.example.JsonFlightEntityConverter;
import org.example.model.*;
import org.example.repository.FlightInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService implements FlightInterface {

    private List<FlightEntity> flightEntityList;
    private List<ContainerEntity> containerEntityList;

    public FlightService() {
        this.flightEntityList = JsonFlightEntityConverter.readFlightEntityJson();
        this.containerEntityList = JsonContainerEntityConverter.readCargoEntityJson();
    }

    @Override
    public void getCargoAndBaggageWeightFromRequestedFlight(Integer flightNumber, LocalDate flightDate) {

        Optional<FlightEntity> flightData = flightEntityList.stream()
                .filter(flight -> flight.getFlightNumber().equals(flightNumber))
                .filter(flight -> flight.getDepartureDate().toLocalDate().equals(flightDate))
                .findAny();

        List<ContainerEntity> containers = containerEntityList.stream()
                .filter(cargoEntity -> cargoEntity.getFlightId().equals(flightData.get().getFlightId()))
                .collect(Collectors.toList());

        int baggageWeight = 0;
        int cargoWeight = 0;
        int totalCargo = 0;

        for (ContainerEntity c : containers) {
            for (Container baggage : c.getBaggage()) {
                baggageWeight += baggage.getWeight();
            }
            for (Container cargo : c.getCargo()) {
                cargoWeight += cargo.getWeight();
            }
        }
        totalCargo = baggageWeight + cargoWeight;
        System.out.println(baggageWeight);
        System.out.println(cargoWeight);
        System.out.println(totalCargo);
    }

    @Override
    public void getNumberOfFlightsDepartingFromAirport(DepartureAirportIATACode IATAAirportCode, LocalDate flightDate) {

        List<FlightEntity> numberOfFlights = flightEntityList.stream()
                .filter(flightEntity -> flightEntity.getDepartureAirportIATACode().equals(IATAAirportCode))
                .filter(flightEntity -> flightEntity.getDepartureDate().toLocalDate().equals(flightDate))
                .collect(Collectors.toList());

        System.out.println("Number of flights departing from this airport: " + numberOfFlights.size());
    }

    @Override
    public void getNumberOfFlightsArrivingToAirport(ArrivalAirportIATACode IATAAirportCode, LocalDate flightDate) {

        List<FlightEntity> numberOfFlights = flightEntityList.stream()
                .filter(flightEntity -> flightEntity.getArrivalAirportIATACode().equals(IATAAirportCode))
                .filter(flightEntity -> flightEntity.getDepartureDate().toLocalDate().equals(flightDate))
                .collect(Collectors.toList());

        System.out.println("Number of flights arriving to this airport: " + numberOfFlights.size());

    }

    @Override
    public void getNumberOfPiecesOfBaggagesArrivingToAirport(ArrivalAirportIATACode IATAAirportCode, LocalDate flightDate) {
        try {

            Optional<FlightEntity> flightData = flightEntityList.stream()
                    .filter(flightEntity -> flightEntity.getArrivalAirportIATACode().equals(IATAAirportCode))
                    .filter(flightEntity -> flightEntity.getDepartureDate().toLocalDate().equals(flightDate))
                    .findAny();

            if (!flightData.isEmpty()) {

                List<ContainerEntity> baggageData = containerEntityList.stream()
                        .filter(containerEntity -> containerEntity.getFlightId().equals(flightData.get().getFlightId()))
                        .collect(Collectors.toList());

                int baggagePieces = 0;

                for (ContainerEntity c : baggageData) {
                    for (Container baggage : c.getBaggage()) {
                        baggagePieces += baggage.getPieces();
                    }
                }
                System.out.println("Total number (pieces) of baggage arriving to this airport: " + baggagePieces);
            } else {
                System.out.println("There are no baggages arriving to this airport according to the given data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getNumberOfPiecesOfBaggagesDepartingFromAirport(DepartureAirportIATACode IATAAirportCode, LocalDate flightDate) {
        try {
            Optional<FlightEntity> flightData = flightEntityList.stream()
                    .filter(flightEntity -> flightEntity.getDepartureAirportIATACode().equals(IATAAirportCode))
                    .filter(flightEntity -> flightEntity.getDepartureDate().toLocalDate().equals(flightDate))
                    .findAny();

            if (!flightData.isEmpty()) {

                List<ContainerEntity> baggageData = containerEntityList.stream()
                        .filter(containerEntity -> containerEntity.getFlightId().equals(flightData.get().getFlightId()))
                        .collect(Collectors.toList());

                int baggagePieces = 0;

                for (ContainerEntity c : baggageData) {
                    for (Container baggage : c.getBaggage()) {
                        baggagePieces += baggage.getPieces();
                    }
                }

                System.out.println("Total number (pieces) of baggage departing from this airport: " + baggagePieces);
            } else {
                System.out.println("There are no baggages departing from this airport according to the given data");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
