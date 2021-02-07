package org.example.service;

import org.example.JsonContainerEntityConverter;
import org.example.JsonFlightEntityConverter;
import org.example.model.ContainerEntity;
import org.example.model.Container;
import org.example.model.FlightEntity;
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
}
