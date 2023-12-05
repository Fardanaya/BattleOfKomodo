import src.Controller.Auth;
import src.Controller.Model;
import src.Controller.Setup;
import src.Model.Data.ModelDragon;
import src.Model.JSON.ModelDragonJSON;
import src.Model.JSON.ModelPlayerJSON;
import src.Node.Data.Skill;
import src.Node.Data.Player;
import src.Node.Data.Element;
import src.Node.Data.Age;
import src.Node.Data.Dragon;
import src.View.ClearScreen;
import src.View.DragonView;
import src.View.ElementView;
import src.View.Menu;
import src.View.playerView;
import src.View.SkillView;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        model.Complete();
        Setup setup = new Setup();
        setup.Complete();
        ClearScreen.clearConsole();

    
        // Auth auth = new Auth();
        // auth.register();
        // auth.login();

        // DONE BUT NOT IMPLEMENTED YET
        // Menu menu = new Menu();
        // menu.mainMenu();

        // DONE
        DragonView dragmenu = new DragonView();
        dragmenu.showAllDragon(Model.dragonList.getAllDragons());
        // Insert Skill to dragon
        Model.dragonList.getDragon(0).addSkill(Model.skillList.getSkill(0));

        // DONEE
        playerView playermenu = new playerView();
        playermenu.showAllPlayerDetails(Model.playerList.getAllPlayers());
        // Insert Dragon to player
        Model.playerList.getPlayer(0).addDragonToPlayer(Model.dragonList.getAllDragons().get(0));

        // DONE
        ElementView elementmenu = new ElementView();
        elementmenu.showAllElementDetails(Model.element.getAllElements());

        SkillView skillmenu = new SkillView();
        skillmenu.showAllSkillDetails(Model.skillList.getAllSkill());
        
        // SAVING DATA TO JSON FILE
        Model.dragonList.saveData();
        Model.skillList.saveData();
        Model.playerList.saveData();
    }
}