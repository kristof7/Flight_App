package org.example.model;

import java.util.List;
import java.util.Map;

public class CargoEntity {


    private Integer flightId;
    private Map<String, List<Container>> containerMap;

    public Map<String, List<Container>> getContainerMap() {
        return containerMap;
    }

    public void setContainerMap(Map<String, List<Container>> containerMap) {
        this.containerMap = containerMap;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

}
