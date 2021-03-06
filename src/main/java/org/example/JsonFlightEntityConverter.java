package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.FlightEntity;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class JsonFlightEntityConverter {

    private static final String jsonFlightEntityFilename = "src/main/resources/flightEntity.json";
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
    private static final Type collectionType = new TypeToken<List<FlightEntity>>() {
    }.getType();

    public static List<FlightEntity> readFlightEntityJson() {
        List<FlightEntity> flightList = null;
        try (FileReader fileReader = new FileReader(jsonFlightEntityFilename)) {
            flightList = gson.fromJson(fileReader, collectionType);
        } catch (IOException e) {
            System.err.println("From Json, json filename exception : " + e.getMessage());
        }
        return flightList;
    }
}