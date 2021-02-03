package org.example;

import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    private static final String flightEntityFilePath = "flightEntity.json";
    private static final String cargoEntityFilePath = "cargoEntity.json";

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(flightEntityFilePath)) {

            FlightListJsonConverter flightListJsonConverter = new FlightListJsonConverter(flightEntityFilePath);
            Optional<Object> flightEntity = flightListJsonConverter.readJson();

            Date date = new Date();


            CargoListJsonConverter cargoListJsonConverter = new CargoListJsonConverter(cargoEntityFilePath);
            Optional<Object> cargoEntity = cargoListJsonConverter.readJson();

            getData1(0, date, flightEntity, cargoEntity);
            getData2("SEA", date, flightEntity, cargoEntity);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getData1(Integer flightNumber, Date flightDate, Optional<Object> flightEntity, Optional<Object> cargoEntity) {

    }

    public static void getData2(String iataAirportCode, Date flightDate, Optional<Object> flightEntity, Optional<Object> cargoEntity) {

    }

}