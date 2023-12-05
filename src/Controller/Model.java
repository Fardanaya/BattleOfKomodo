package src.Controller;

import src.Model.Data.ModelAge;
import src.Model.Data.ModelDragon;
import src.Model.Data.ModelElement;
import src.Model.Data.ModelPlayer;
import src.Model.Data.ModelSkill;
import src.View.Message;

public class Model {
    // REQUIRED BY GAME
    public static ModelElement element = new ModelElement();
    public static ModelAge age = new ModelAge();
    public static ModelPlayer playerList = new ModelPlayer();
    public static ModelSkill skillList = new ModelSkill(); // FIXME: MASIH BELUM SELESAI
    public static ModelDragon dragonList = new ModelDragon();

    Message gameMessage = new Message();

    public Model() {
        gameMessage.alert("Loading Data...");
    }

    public void Complete() {
        gameMessage.alert("Successfully Load Data !");
    }
}
