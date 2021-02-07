package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.CargoEntity;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class JsonCargoConverter {

    private final String jsonCargoEntityFilename = "src/main/resources/cargoEntity.json";
    private final Gson cargoEntityGson = new Gson();
    private final Type collectionType = new TypeToken<Collection<Object>>() {
    }.getType();

    //        final Type collectionType = new TypeToken<List<CargoEntity>>() {}.getType();
//        List<CargoEntity> cargoList = null;

    public List<CargoEntity> readCargoEntityJson() {
        final Type collectionType = new TypeToken<List<CargoEntity>>() {
        }.getType();
        List<CargoEntity> cargoList = null;
        try (FileReader fileReader = new FileReader(jsonCargoEntityFilename)) {
            cargoList = cargoEntityGson.fromJson(fileReader, collectionType);
        } catch (IOException e) {
            System.err.println("From Json, json filename exception : " + e.getMessage());
        }
        return cargoList;
    }
}


//    public static List<CargoEntity> readCargoJson() {
//
//        Gson gson = new Gson();
//
//        final Type collectionType = new TypeToken<List<CargoEntity>>() {}.getType();
//        List<CargoEntity> cargoList = null;
//
//        try (FileReader fileReader = new FileReader("cargoEntity.json")) {
//            cargoList = gson.fromJson(fileReader, collectionType);
//        } catch (IOException e) {
//            System.err.println("From Json, json filename exception : " + e.getMessage());
//        }
//
//        for (int i = 0; i < cargoList.size(); i++) {
//            System.out.println(cargoList.get(i).getContainerMap());
//        }
//
//        return cargoList;
//
//    }


//    public FlightEntity readJson() {
//        try (FileReader fileReader = new FileReader(jsonFilename)) {
//            return gson.fromJson(fileReader, collectionType);
//        } catch (IOException e) {
//            System.err.println("From Json, json filename exception : " + e.getMessage());
//        }
//        return new FlightEntity();
//    }

