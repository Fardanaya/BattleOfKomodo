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

        // PLAYER

        // setplayer
        Data.setPlayer(Data.playerList.getAccount(0));
        // Data.playerList.getAccount(0).getPlayer().addDragonToPlayer(Data.dragonList.getDragon(1));
        // Data.playerList.getAccount(0).getPlayer().addDragonToPlayer(Data.dragonList.getDragon(0));
        // Data.playerList.getAccount(0).getPlayer().addDragonToPlayer(Data.dragonList.getDragon(2));

        // Add Account
        // Account account = new Account("admin", "admin");
        // Data.playerList.addPlayer(account);

        // viewData playermenu = new viewData();
        // playermenu.showAllPlayerDetails(Data.playerList.getAllPlayers());
        // Insert Dragon to player
        // Data.playerList.getPlayer(0).getPlayer().addDragonToPlayer(Data.dragonList.getAllDragons().get(1));



        // BATTLE

        ArrayList<Dragon> playerDragon = new ArrayList<>();
        playerDragon.add(Data.dragonList.getDragon(0));
        playerDragon.add(Data.dragonList.getDragon(2));
        playerDragon.add(Data.dragonList.getDragon(1));

        ArrayList<Dragon> botDragon = new ArrayList<>();
        botDragon.add(Data.dragonList.getDragon(1));
        // botDragon.add(Data.dragonList.getDragon(0));
        // botDragon.add(Data.dragonList.getDragon(2));

        Player p = new Player();
        p.setDeck(playerDragon);
        
        BattleController battle = new BattleController(p.battleDragons(), new Bot(botDragon).battleDragons());
        battle.startBattle();

        // DUMMY BATTLE
        // Battle battle = new Battle(player, bot);
        // battle.startBattle();

        // ELEMENT DONE
        // viewData element = new viewData();
        // element.showAllElementDetails(Data.element.getAllElements());

        // SKILL
        // SkillView skillmenu = new SkillView();
        // skillmenu.showAllSkillDetails(Data.skillList.getAllSkill());




        // VIEW
        // UserController user = new UserController();
        // user.userMenu();
    }
}
