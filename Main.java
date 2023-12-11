import java.util.ArrayList;

import src.Controller.Auth;
import src.Controller.Battle;
import src.Controller.Data;
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

        // PREPARING THE GAME...
        Data model = new Data();
        model.Complete();
        Setup setup = new Setup();
        setup.Complete();
        ClearScreen.clearConsole();
        // SUCCESSFULLY LOADED...

        // STARTING GAME
        // Menu menu = new Menu();
        // menu.userAuth();

        // System.out.println("Login Success ! Welcome to Dragon Game " +
        // Model.player.getUsername());

        // Run the battle

        Data.setPlayer(Data.playerList.getPlayer(0));

        ArrayList<Dragon> player = new ArrayList<>();
        player.add(Data.dragonList.getDragon(0));
        player.add(Data.dragonList.getDragon(1));

        ArrayList<Dragon> bot = new ArrayList<>();
        bot.add(Data.dragonList.getDragon(1));
        bot.add(Data.dragonList.getDragon(0));

        Battle battle = new Battle(player, bot);
        battle.startBattle();

        // DONE
        // DragonView dragmenu = new DragonView();
        // dragmenu.showAllDragon(Model.dragonList.getAllDragons());
        // Insert Skill to dragon
        // Model.dragonList.getDragon(0).addSkill(Model.skillList.getSkill(0));

        // DONEE
        // playerView playermenu = new playerView();
        // playermenu.showAllPlayerDetails(Model.playerList.getAllPlayers());
        // Insert Dragon to player
        // Model.playerList.getPlayer(0).addDragonToPlayer(Model.dragonList.getAllDragons().get(0));

        // DONE
        // ElementView elementmenu = new ElementView();
        // elementmenu.showAllElementDetails(Model.element.getAllElements());

        // SkillView skillmenu = new SkillView();
        // skillmenu.showAllSkillDetails(Model.skillList.getAllSkill());

        // SAVING DATA TO JSON FILE
        // Model.dragonList.saveData();
        // Model.skillList.saveData();
        // Model.playerList.saveData();
    }
}