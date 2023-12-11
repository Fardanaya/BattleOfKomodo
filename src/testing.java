package src;

import src.Controller.*;
import src.View.*;

public class testing {
    public static void test() {

        // BATTLE
        // Data.setPlayer(Data.playerList.getPlayer(0));

        // ArrayList<Dragon> player = new ArrayList<>();
        // player.add(Data.dragonList.getDragon(0));
        // player.add(Data.dragonList.getDragon(1));

        // ArrayList<Dragon> bot = new ArrayList<>();
        // bot.add(Data.dragonList.getDragon(1));
        // bot.add(Data.dragonList.getDragon(0));

        // Battle battle = new Battle(player, bot);
        // battle.startBattle();



        // DRAGON
        // DragonView dragmenu = new DragonView();
        // dragmenu.showAllDragon(Model.dragonList.getAllDragons());
        // Insert Skill to dragon
        // Model.dragonList.getDragon(0).addSkill(Model.skillList.getSkill(0));



        // PLAYER DONE
        // playerView playermenu = new playerView();
        // playermenu.showAllPlayerDetails(Model.playerList.getAllPlayers());
        // Insert Dragon to player
        // Model.playerList.getPlayer(0).addDragonToPlayer(Model.dragonList.getAllDragons().get(0));



        // ELEMENT  DONE
        viewData element = new viewData();
        element.showAllElementDetails(Data.element.getAllElements());



        // SKILL
        // SkillView skillmenu = new SkillView();
        // skillmenu.showAllSkillDetails(Model.skillList.getAllSkill());
    }
}
