package org.example.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Flight {
    private Integer flightId;
    private Integer flightNumber;
    private DepartureAirportIATACode departureAirportIATACode;
    private ArrivalAirportIATACode arrivalAirportIATACode;
    private Date departureDate;

    public Integer getFlightId() {
        return flightId;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public DepartureAirportIATACode getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public ArrivalAirportIATACode getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
