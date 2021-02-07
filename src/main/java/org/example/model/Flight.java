package org.example.model;

import java.time.LocalDateTime;

public class Flight {
    private Integer flightId;
    private Integer flightNumber;
    private DepartureAirportIATACode departureAirportIATACode;
    private ArrivalAirportIATACode arrivalAirportIATACode;
    private LocalDateTime departureDate;

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
        return departureDate;
    }


//    {
//        "flightId": 0,
//            "flightNumber": 5617,
//            "departureAirportIATACode": "YYZ",
//            "arrivalAirportIATACode": "LEW",
//            "departureDate": "2018-08-16T06:19:00 -02:00"
//    },
}
