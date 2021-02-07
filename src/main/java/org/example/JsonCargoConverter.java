package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Container;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonCargoConverter {

    private final String jsonCargoEntityFilename = "src/main/resources/cargoEntity.json";
    private final Gson gson = new Gson();
    final Type collectionType = new TypeToken<Map<String, List<Container>>>() {
    }.getType();

    public List<Container> readCargoEntityJson() {
        List<Container> containerList = null;
        try (FileReader fileReader = new FileReader(jsonCargoEntityFilename)) {
            containerList = gson.fromJson(fileReader, collectionType);
        } catch (IOException e) {
            System.err.println("From Json, json filename exception : " + e.getMessage());
        }

//        for (Container c: containerList) {
//            System.out.println(c);
//        }
        return containerList;
    }
}

//==============================================================================

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


