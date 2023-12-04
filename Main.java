import src.Controller.Auth;
import src.Controller.Model;
import src.Model.Data.ModelDragon;
import src.Model.JSON.ModelDragonJSON;
import src.Model.JSON.ModelPlayerJSON;
import src.Node.Data.Player;
import src.Node.Data.Element;
import src.Node.Data.AgeStage;
import src.Node.Data.Dragon;
import src.View.ClearScreen;
import src.View.DragonMenu;
import src.View.Menu;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        model.Complete();
        ClearScreen.clearConsole();

        // FILE DATABASE 
        ModelPlayerJSON databasePlayer = new ModelPlayerJSON();
        databasePlayer.setupFile();
        ModelDragonJSON modelDragon = new ModelDragonJSON();
        modelDragon.setupFile();

        // SAVING DATA TO MEMORY
        Model.dragonList.addDragon(new Dragon("Dragon", "Dragon", 1, 1, 1, 1, 1, 1, new Element("Fire", 0, 0), new AgeStage("Remaja")));
        Model.dragonList.addDragon(new Dragon("Dragon2", "Dragon2", 1, 1, 1, 1, 1, 1, new Element("Earth", 0, 0), new AgeStage("Dewasa")));
         
        Model.playerList.addPlayer(new Player("Davin", "avux0000"));
        Model.playerList.addPlayer(new Player("Franky", "franky69"));
    
        // Auth auth = new Auth();
        // auth.register();
        // auth.login();

        // DONE BUT NOT IMPLEMENTED YET
        // Menu menu = new Menu();
        // menu.mainMenu();
        DragonMenu dragmenu = new DragonMenu();
        dragmenu.showAllDragon(Model.dragonList.getAllDragons());

        // SAVING DATA TO JSON FILE
        Model.playerList.saveData();
        Model.dragonList.saveData();
    }
}