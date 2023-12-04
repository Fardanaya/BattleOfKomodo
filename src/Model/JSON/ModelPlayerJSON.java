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

import src.View.Message;
import src.Node.Data.Player;
import src.Node.JSON.JsonPlayer;

public class ModelPlayerJSON {

    Message gameMessage = new Message();
    JsonPlayer jsonPlayer = new JsonPlayer();
    String fname = "database/Game/Player.json";

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

    public JsonArray convertArrayListToJsonArray(ArrayList<Player> playerList) {
        if (playerList == null) {
            return null;
        } else {
            JsonArray JSONplayer = new JsonArray();
            for (Player player : playerList) {
                JsonObject playerObject = new JsonObject();
                playerObject.addProperty(jsonPlayer.nickname, player.getNickname());
                playerObject.addProperty(jsonPlayer.username, player.getUsername());
                playerObject.addProperty(jsonPlayer.password, player.getPassword());
                JSONplayer.add(playerObject);
            }
            return JSONplayer;
        }
    }

    public ArrayList<Player> convertJsonArraytoArrayList(JsonArray JSONarray) {
        if (JSONarray == null) {
            return null;
        } else {
            ArrayList<Player> ListPlayer = new ArrayList<>();
            for (Object PlayerObj : JSONarray) {
                JsonObject Player = (JsonObject) PlayerObj;
                String nickname = Player.get(jsonPlayer.nickname).toString();
                String username = Player.get(jsonPlayer.username).toString();
                String password = Player.get(jsonPlayer.password).toString();
                ListPlayer.add(new Player(nickname, username, password));
            }
            return ListPlayer;
        }
    }

public void writeDataJSON(ArrayList<Player> playerList) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(playerList);
    try (FileWriter file = new FileWriter(fname)) {
        file.write(json);
    } catch (IOException e) {
        System.out.println("Error.");
        e.printStackTrace();
    }
}

    public ArrayList<Player> readDataJSON() {
        ArrayList<Player> playerList = new ArrayList<>();
        try (Reader reader = new FileReader(fname)) {
            JsonArray jsonPlayer = new Gson().fromJson(reader, JsonArray.class);
            playerList = convertJsonArraytoArrayList(jsonPlayer);
        } catch (IOException e) {
            // System.out.println("Data Kosong. Error :");
            // e.printStackTrace();
        }
        return playerList;
    }

}