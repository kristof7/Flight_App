package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.ContainerEntity;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonContainerEntityConverter {

    private static final String jsonCargoEntityFilename = "src/main/resources/cargoEntity.json";
    private static final Gson gson = new Gson();
    final static Type collectionType = new TypeToken<List<ContainerEntity>>() {
    }.getType();


    public static List<ContainerEntity> readCargoEntityJson() {
        List<ContainerEntity> containerList = null;
        try (FileReader fileReader = new FileReader(jsonCargoEntityFilename)) {
            containerList = gson.fromJson(fileReader, collectionType);
        } catch (IOException e) {
            System.err.println("From Json, json filename exception : " + e.getMessage());
        }
        return containerList;
    }
}


