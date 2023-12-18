package src.Model.Data;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import src.Model.JSON.ModelJSON;
import src.Node.Data.Account;

public class ModelPlayer {
    public ArrayList<Account> PlayerList;
    ModelJSON<Account> dataJSON;

    public ModelPlayer() {
        this.dataJSON = new ModelJSON<>("Database/Game/Player.json");
        fetchJsonData();
    }

    public void fetchJsonData() {
        this.PlayerList = dataJSON.readFromFile(new TypeToken<ArrayList<Account>>() {}.getType());
    }

    public void addPlayer(Account player) {
        this.PlayerList.add(player);
    }

    public void updatePlayer(int index, Account player) {
        this.PlayerList.set(index, player);
    }

    public int searchPlayer(String username) {
        for (Account player : PlayerList) {
            if (player.getUsername().equals(username)) {
                return PlayerList.indexOf(player);
            }
        }
        return -1;
    }

    public Account getPlayer(int index) {
        return PlayerList.get(index);
    }

    public ArrayList<Account> getAllPlayers() {
        return PlayerList;
    }

    public boolean saveData() {
        try {
            dataJSON.writeToFile(PlayerList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
