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
                playerObject.put(jsonPlayer.nickname, player.getNickname());
                playerObject.put(jsonPlayer.username, player.getUsername());
                playerObject.put(jsonPlayer.password, player.getPassword());
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

    public ArrayList<Player> readDataJSON() {
        ArrayList<Player> playerList = new ArrayList<>();
        try (FileReader file = new FileReader(fname)) {
            JsonArray jsonPlayer = (JsonArray) Jsoner.deserialize(file);
            playerList = convertJsonArraytoArrayList(jsonPlayer);
        } catch (IOException | JsonException e) {
            // System.out.println("Data Kosong. Error :");
            // e.printStackTrace();
        }
        return playerList;
    }

}