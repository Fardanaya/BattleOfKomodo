package src.Model.JSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import src.Node.Data.AgeStage;
import src.Node.Data.Dragon;
import src.Node.Data.Element;
import src.Node.JSON.JsonDragon;
import src.View.Message;

public class ModelDragonJSON {

    String fname = "database/Game/Dragon.json";
    Message gameMessage = new Message();
    JsonDragon jsonDragon = new JsonDragon();

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
                    gameMessage.alert("File telah dibuat - " + file.getName());
                }
            }
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    public JsonArray convertArrayListToJsonArray(ArrayList<Dragon> dragonList) {
        if (dragonList == null) {
            return null;
        } else {
            JsonArray JSONDragon = new JsonArray();
            for (Dragon dragon : dragonList) {
                JsonObject dragonObject = new JsonObject();
                dragonObject.addProperty(jsonDragon.id, dragon.getId());
                dragonObject.addProperty(jsonDragon.name, dragon.getName());
                dragonObject.addProperty(jsonDragon.lvl, dragon.getLevel());
                dragonObject.addProperty(jsonDragon.attack, dragon.getAttack());
                dragonObject.addProperty(jsonDragon.defense, dragon.getDefense());
                dragonObject.addProperty(jsonDragon.hp, dragon.getMaxHP());
                dragonObject.addProperty(jsonDragon.xp, dragon.getExperience());

                JsonObject elementObject = new JsonObject();
                Element element = dragon.getElement();
                elementObject.addProperty("name", element.getName());
                elementObject.addProperty("weakness", element.getWeakness());
                elementObject.addProperty("strength", element.getStrength());
                dragonObject.add(jsonDragon.element, elementObject);

                JsonObject ageStageObject = new JsonObject();
                AgeStage ageStage = dragon.getAgeStage();
                ageStageObject.addProperty("name", ageStage.getStageName());
                dragonObject.add(jsonDragon.ageStage, ageStageObject);

                JSONDragon.add(dragonObject);
            }
            return JSONDragon;
        }
    }

    public ArrayList<Dragon> convertJsonArraytoArrayList(JsonArray JSONarray) {
        if (JSONarray == null) {
            return null;
        } else {
            ArrayList<Dragon> ListDragon = new ArrayList<>();
            for (Object dragonObj : JSONarray) {
                JsonObject dragonJson = (JsonObject) dragonObj;
                String id = dragonJson.get(jsonDragon.id).toString();
                String name = dragonJson.get(jsonDragon.name).toString();
                String lvl = dragonJson.get(jsonDragon.lvl).toString();
                String attack = dragonJson.get(jsonDragon.attack).toString();
                String defense = dragonJson.get(jsonDragon.defense).toString();
                String hp = dragonJson.get(jsonDragon.hp).toString();
                String maxhp = dragonJson.get(jsonDragon.hp).toString();
                String xp = dragonJson.get(jsonDragon.xp).toString();

                JsonObject elementJson = (JsonObject) dragonJson.get(jsonDragon.element);
                String elementName = elementJson.get("name").toString();
                String elementWeakness = elementJson.get("weakness").toString();
                String elementStrength = elementJson.get("strength").toString();

                int parsedWeakness;
                int parsedStrength;

                try {
                    parsedWeakness = Integer.parseInt(elementWeakness);
                    parsedStrength = Integer.parseInt(elementStrength);
                } catch (NumberFormatException e) {
                    parsedWeakness = 0;
                    parsedStrength = 0;
                }

                Element element = new Element(elementName, parsedWeakness, parsedStrength);

                JsonObject ageStageJson = (JsonObject) dragonJson.get(jsonDragon.ageStage);
                String ageStageName = ageStageJson.get("name").toString();
                AgeStage ageStage = new AgeStage(ageStageName);

                ListDragon.add(new Dragon(id, name, Integer.parseInt(lvl), Integer.parseInt(attack),
                        Integer.parseInt(defense), Integer.parseInt(hp), Integer.parseInt(maxhp), Integer.parseInt(xp),
                        element, ageStage));
            }
            return ListDragon;
        }
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
            JsonArray jsonDragon = new Gson().fromJson(reader, JsonArray.class);
            dragonList = convertJsonArraytoArrayList(jsonDragon);
        } catch (IOException e) {
            // System.out.println("Data Kosong. Error :");
            // e.printStackTrace();
        }
        return dragonList;
    }
}
