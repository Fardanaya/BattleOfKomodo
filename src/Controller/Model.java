package src.Controller;

import src.Model.Data.ModelDragon;
import src.Model.Data.ModelPlayer;
import src.View.Message;

public class Model {
    public static ModelPlayer playerList = new ModelPlayer();
    public static ModelDragon dragonList = new ModelDragon();

    Message gameMessage = new Message();

    public Model() {
        gameMessage.alert("Loading Data...");
    }

    public void Complete() {
        gameMessage.alert("Successfully Load Data !");
    }
}
