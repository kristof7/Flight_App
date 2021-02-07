package org.example.model;

import java.util.List;

public class ContainerEntity {

    private Integer flightId;
    private List<Container> baggage;
    private List<Container> cargo;

    public Integer getFlightId() {
        return flightId;
    }

    public List<Container> getBaggage() {
        return baggage;
    }

    public List<Container> getCargo() {
        return cargo;
    }
}
