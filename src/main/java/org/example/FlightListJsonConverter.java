package org.example;

public class FlightListJsonConverter extends JsonConverter<FlightEntity> {
    public FlightListJsonConverter(String jsonFilename) {
        super(jsonFilename);
    }
}
