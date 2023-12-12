package src.Model.JSON;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import src.Node.Data.Dragon;
import src.View.Game;

public class ModelDragonJSON {

    String fname = "database/Game/Dragon.json";
    Game gameMessage = new Game();

    public ModelDragonJSON() {
        setupFile();
    }

    public boolean checkFile() {
        boolean status = false;
        if (new java.io.File(fname).exists()) {
            status = true;
        }
        return status;
    }

    public void setupFile() {
        try {
            if (checkFile() == false) {
                File file = new File(fname);
                if (file.createNewFile()) {
                    try (FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                        bufferedWriter.write("[]");
                        gameMessage.alert("File telah dibuat - " + file.getName());
                    } catch (IOException e) {
                        gameMessage.alert("File telah dibuat Dengan Error !!! - " + file.getName());
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    public JsonArray convertArrayListToJsonArray(ArrayList<Dragon> dragonList) {
        return new Gson().toJsonTree(dragonList).getAsJsonArray();
    }

    private ArrayList<Dragon> convertJsonArraytoArrayList(JsonArray jsonDragonList) {
        Gson gson = new Gson();
        Type dragonListType = new TypeToken<ArrayList<Dragon>>() {
        }.getType();
        ArrayList<Dragon> dragonList = gson.fromJson(jsonDragonList, dragonListType);
        return dragonList;
    }

    public void writeDataJSON(ArrayList<Dragon> dragonList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dragonList);
        try (FileWriter file = new FileWriter(fname)) {
            file.write(json);
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    public ArrayList<Dragon> readDataJSON() {
        ArrayList<Dragon> dragonList = new ArrayList<>();
        try (Reader reader = new FileReader(fname)) {
            JsonArray jsonPlayer = new JsonParser().parse(reader).getAsJsonArray();
            dragonList = convertJsonArraytoArrayList(jsonPlayer);
        } catch (IOException e) {
            // System.out.println("Data Kosong. Error :");
            // e.printStackTrace();
        } catch (JsonParseException e) {
            // System.out.println("File Kosong");
        }
        return dragonList;
    }
}
