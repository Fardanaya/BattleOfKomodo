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

import src.View.Game;
import src.Node.Data.Skill;

public class ModelSkillJSON {

    Game gameMessage = new Game();
    String fname = "database/Game/Skill.json";

    public ModelSkillJSON() {
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

    // public JsonArray convertArrayListToJsonArray(ArrayList<Skill> skillList) {
        
    public JsonArray convertArrayListToJsonArray(ArrayList<Skill> skillList) {
        return new Gson().toJsonTree(skillList).getAsJsonArray();
    }

    private ArrayList<Skill> convertJsonArraytoArrayList(JsonArray jsonSkillList) {
        Gson gson = new Gson();
        Type skillListType = new TypeToken<ArrayList<Skill>>() {
        }.getType();
        ArrayList<Skill> skillList = gson.fromJson(jsonSkillList, skillListType);
        return skillList;
    }

    public void writeDataJSON(ArrayList<Skill> skillList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(skillList);
        try (FileWriter file = new FileWriter(fname)) {
            file.write(json);
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    public ArrayList<Skill> readDataJSON() {
        ArrayList<Skill> skillList = new ArrayList<>();
        try (Reader reader = new FileReader(fname)) {
            JsonArray jsonSkill = new JsonParser().parse(reader).getAsJsonArray();
            skillList = convertJsonArraytoArrayList(jsonSkill);
        } catch (IOException e) {
            System.out.println("Data Kosong. Error :");
            e.printStackTrace();
        } catch (JsonParseException e) {
            System.out.println("File Kosong");
        }
        return skillList;
    }

}