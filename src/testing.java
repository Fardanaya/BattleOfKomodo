package src;

import java.util.ArrayList;

import src.Controller.*;
import src.Node.Data.*;
import src.View.*;

public class testing {
    public static void test() {

        // DRAGON
        // viewData dragmenu = new viewData();
        // dragmenu.showAllDragon(Data.dragonList.getAllDragons());
        // Insert Skill to dragon
        // Data.dragonList.getDragon(0).addSkill(Data.skillList.getSkill(0));



        // PLAYER DONE
        // playerView playermenu = new playerView();
        // playermenu.showAllPlayerDetails(Data.playerList.getAllPlayers());
        // Insert Dragon to player
        // Data.playerList.getPlayer(0).addDragonToPlayer(Data.dragonList.getAllDragons().get(1));
        // BATTLE
        // Data.setPlayer(Data.playerList.getPlayer(0));
        
        
        
        ArrayList<Dragon> player = new ArrayList<>();
        player.add(Data.dragonList.getDragon(0));
        player.add(Data.dragonList.getDragon(1));

        ArrayList<Dragon> bot = new ArrayList<>();
        bot.add(Data.dragonList.getDragon(1));
        bot.add(Data.dragonList.getDragon(0));

        Battle battle = new Battle(player, bot);
        battle.startBattle();



        // ELEMENT  DONE
        // viewData element = new viewData();
        // element.showAllElementDetails(Data.element.getAllElements());



        // SKILL
        // SkillView skillmenu = new SkillView();
        // skillmenu.showAllSkillDetails(Data.skillList.getAllSkill());
    }
}
