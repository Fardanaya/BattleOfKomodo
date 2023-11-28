package src.Model.JSON;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

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
                dragonObject.put(jsonDragon.id, dragon.getId());
                dragonObject.put(jsonDragon.name, dragon.getName());
                dragonObject.put(jsonDragon.lvl, dragon.getLevel());
                dragonObject.put(jsonDragon.attack, dragon.getAttack());
                dragonObject.put(jsonDragon.defense, dragon.getDefense());
                dragonObject.put(jsonDragon.hp, dragon.getMaxHP());
                dragonObject.put(jsonDragon.xp, dragon.getExperience());

                JsonObject elementObject = new JsonObject();
                Element element = dragon.getElement();
                elementObject.put("name", element.getName());
                elementObject.put("weakness", element.getWeakness());
                elementObject.put("strength", element.getStrength());
                dragonObject.put(jsonDragon.element, elementObject);

                JsonObject ageStageObject = new JsonObject();
                AgeStage ageStage = dragon.getAgeStage();
                ageStageObject.put("name", ageStage.getStageName());
                dragonObject.put(jsonDragon.ageStage, ageStageObject);

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

                ListDragon.add(new Dragon(id, name, Integer.parseInt(lvl), Integer.parseInt(attack), Integer.parseInt(defense), Integer.parseInt(hp), Integer.parseInt(maxhp), Integer.parseInt(xp), element, ageStage));
            }
            return ListDragon;
        }
    }

    public void writeDataJSON(ArrayList<Dragon> playerList) {
        JsonArray JSONplayer = convertArrayListToJsonArray(playerList);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(JSONplayer.toJson());
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    public ArrayList<Dragon> readDataJSON() {
        ArrayList<Dragon> dragonList = new ArrayList<>();
        try (FileReader file = new FileReader(fname)) {
            JsonArray jsonDragon = (JsonArray) Jsoner.deserialize(file);
            dragonList = convertJsonArraytoArrayList(jsonDragon);
        } catch (IOException | JsonException e) {
            // System.out.println("Data Kosong. Error :");
            // e.printStackTrace();
        }
        return dragonList;
    }
}
