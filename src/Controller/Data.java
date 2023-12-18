package src.Controller;

import src.Model.Data.*;

import src.Node.Data.Account;

import src.View.Input;
import src.View.Game;

public class Data {
    // REQUIRED BY GAME
    public static Input input = new Input();
    public static ModelElement element = new ModelElement();
    public static ModelAge age = new ModelAge();

    // REQUIRED DATA
    public static ModelPlayer playerList = new ModelPlayer();
    public static ModelSkill skillList = new ModelSkill();
    public static ModelDragon dragonList = new ModelDragon();

    // REQUIRED USER
    public static Account player;

    Game gameMessage = new Game();

    public Data() {
        gameMessage.alert("Loading Data...");
    }

    public void Complete() {
        gameMessage.alert("Successfully Load Data !");
    }

    public static Account getPlayer() {
        return player;
    }
    
    public static void setPlayer(Account player) {
        Data.player = player;
    }

}
