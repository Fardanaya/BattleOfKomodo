package src.Model;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonArray;

import src.Node.Data.Player;
import src.Model.JSON.ModelPlayer;

public class ModelPlayer {
    ArrayList <Player> PlayerList = new ArrayList();
    
    public void insertPlayer(Player player){
        PlayerList.add(player);
        convertArrayListToJsonArray(PlayerList);
    }
}
