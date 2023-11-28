package src.Model.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import src.View.Message;
import src.Node.Data.Player;
import src.Node.JSON.JsonPlayer;

public class ModelPlayer {

    String fname = "database/Game/Player.json";
    Message gameMessage = new Message();

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
                playerObject.put("username", player.getUsername());
                playerObject.put("password", player.getPassword());
                JSONplayer.add(playerObject);
            }
            return JSONplayer;
        }
    }

    public void writePlayerJSON(ArrayList<Player> playerList) {
        JsonArray JSONplayer = convertArrayListToJsonArray(playerList);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(JSONplayer.toJson());
            file.flush();
            file.close();
        } catch(IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}