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
        // Data.dragonList.getDragon(2).addSkill(Data.skillList.getSkill(2));



        // PLAYER DONE

        // Add Account
        // Account account = new Account("admin", "admin");
        // Data.playerList.addPlayer(account);

        // viewData playermenu = new viewData();
        // playermenu.showAllPlayerDetails(Data.playerList.getAllPlayers());
        // Insert Dragon to player
        // Data.playerList.getPlayer(0).getPlayer().addDragonToPlayer(Data.dragonList.getAllDragons().get(1));
        
        

        // BATTLE
        Data.setPlayer(Data.playerList.getPlayer(0));
        Player avux = new Player();
        avux.setNickname("Avux");
        Data.playerList.getPlayer(0).setPlayer(avux);
        
        ArrayList<Dragon> player = new ArrayList<>();
        player.add(Data.dragonList.getDragon(0));
        player.add(Data.dragonList.getDragon(2));
        player.add(Data.dragonList.getDragon(1));

        ArrayList<Dragon> bot = new ArrayList<>();
        bot.add(Data.dragonList.getDragon(1));
        // bot.add(Data.dragonList.getDragon(0));
        // bot.add(Data.dragonList.getDragon(2));

        BattleController battle = new BattleController(player, bot);
        battle.startBattle();

        // DUMMY BATTLE
        // Battle battle = new Battle(player, bot);
        // battle.startBattle();




        // ELEMENT  DONE
        // viewData element = new viewData();
        // element.showAllElementDetails(Data.element.getAllElements());



        // SKILL
        // SkillView skillmenu = new SkillView();
        // skillmenu.showAllSkillDetails(Data.skillList.getAllSkill());
    }
}
