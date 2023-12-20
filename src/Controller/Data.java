package src.Controller;

import src.Model.Data.*;

import src.Node.Data.Account;

import src.View.*;

public class Data {
    // REQUIRED BY GAME
    public static Input prompt = new Input();
    public static ModelElement element = new ModelElement();
    public static ModelAge age = new ModelAge();

    // REQUIRED DATA
    public static ModelAccount playerList = new ModelAccount();
    public static ModelSkill skillList = new ModelSkill();
    public static ModelDragon dragonList = new ModelDragon();

    // REQUIRED USER
    public static Account player;

    // REQUIRED UI
    public static Game game = new Game();
    public static Menu menu = new Menu();
    public static viewData view = new viewData();

    public Data() {
        Data.game.alert("Loading Data...");
    }

    public void Complete() {
        Data.game.alert("Successfully Load Data !");
    }

    public static Account getPlayer() {
        return player;
    }

    public static void setPlayer(Account player) {
        Data.player = player;
    }

}
