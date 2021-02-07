package org.example.model;

import java.util.Map;

public class CargoEntity {


    private Integer flightId;
    private Map<String, Container[]> containerMap;

    public Map<String, Container[]> getContainerMap() {
        return containerMap;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public void setContainerMap(Map<String, Container[]> containerMap) {
        this.containerMap = containerMap;
    }
}
