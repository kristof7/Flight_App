package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import org.example.model.Flight;

import javax.faces.application.Resource;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;


public class JsonFlightConverter {
    private final String jsonFlightEntityFilename = "src/main/resources/flightEntity.json";
    private final Gson flightEntityGson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
            ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();
    private final Type collectionType = new TypeToken<Collection<Object>>() {
    }.getType();


    public List<Flight> readFlightEntityJson() {
        final Type collectionType = new TypeToken<List<Flight>>() {
        }.getType();
        List<Flight> flightList = null;
        try (FileReader fileReader = new FileReader(jsonFlightEntityFilename)) {
            flightList = flightEntityGson.fromJson(fileReader, collectionType);
        } catch (IOException e) {
            System.err.println("From Json, json filename exception : " + e.getMessage());
        }
        return flightList;
    }
}