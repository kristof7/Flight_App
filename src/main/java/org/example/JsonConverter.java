package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;


public class JsonConverter<T> {
    private final String jsonFilename;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type collectionType = new TypeToken<Collection<Object>>() {
    }.getType();

    public JsonConverter(String jsonFilename) {
        this.jsonFilename = jsonFilename;
    }

    public Optional<Object> readJson() {
        try (FileReader fileReader = new FileReader(jsonFilename)) {
            return Optional.of(gson.fromJson(fileReader, collectionType));
        } catch (IOException e) {
            System.err.println("From Json, json filename exception : " + e.getMessage());
        }
        return Optional.empty();
    }
}
