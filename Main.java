import java.util.ArrayList;

import src.Model.JSON.ModelDragon;
import src.Model.JSON.ModelPlayer;
import src.Node.Data.Player;

public class Main {
    public static void main(String[] args) {
        ModelDragon modelDragon = new ModelDragon();
        modelDragon.setupFile();
        modelDragon.checkFile();
        ModelPlayer modelPlayer = new ModelPlayer();
        modelPlayer.setupFile();
        modelPlayer.checkFile();

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Davin", "avuxgaming123"));
        playerList.add(new Player("Franky", "qwerty"));
        modelPlayer.writePlayerJSON(playerList);

    }
}