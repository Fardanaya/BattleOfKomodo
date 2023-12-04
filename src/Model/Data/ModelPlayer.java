package src.Model.Data;

import java.util.ArrayList;
import src.Model.JSON.ModelPlayerJSON;
import src.Node.Data.Player;

public class ModelPlayer {
    public ArrayList<Player> PlayerList;

    ModelPlayerJSON dataJSON = new ModelPlayerJSON();

    public ModelPlayer() {
        fetchJsonData();
    }

    public void fetchJsonData() {
        this.PlayerList = dataJSON.readDataJSON();
    }

    public void addPlayer(Player player) {
        this.PlayerList.add(player);
    }

    public void updatePlayer(int index, Player player) {
        this.PlayerList.set(index, player);
    }

    public int searchPlayer(String username) {
        for (Player player : PlayerList) {
            if (player.getUsername().equals(username)) {
                return PlayerList.indexOf(player);
            }
        }
        return -1;
    }

    public Player getPlayer(int index) {
        return PlayerList.get(index);
    }

    public ArrayList<Player> getAllPlayers() {
        return PlayerList;
    }

    public boolean saveData() {
        try {
            dataJSON.writeDataJSON(PlayerList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
