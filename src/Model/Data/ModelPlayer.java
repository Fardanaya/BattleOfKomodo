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

    public void showPlayerList() {
        for (Player player : PlayerList) {
            System.out.println("username : " + player.getUsername());
            System.out.println("nickname : " + player.getNickname());
            System.out.println("----------------------");
        }
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
