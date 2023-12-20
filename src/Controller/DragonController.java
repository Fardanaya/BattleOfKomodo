package src.Controller;

import java.util.ArrayList;
import src.Node.Data.*;

public class DragonController {
    public void checkLevelUp(ArrayList<Dragon> dragons) {
        for (Dragon dragon : dragons) {
            DragonController.levelUp(dragon);
        }
    }

    public static void levelUp(Dragon dragon) {
        int level = dragon.getLevel();
        dragon.setLevel(level + 1);
        if (dragon.getLevel() % 5 == 0) {
            dragon.setReqFood((int) ((dragon.getReqFood() + (0.75 * dragon.getReqFood())) / 2) * 2);
        } else {
            dragon.setReqFood((int) ((dragon.getReqFood() + (0.25 * dragon.getReqFood())) / 2) * 2);
        }
        Data.game.print("Dragon " + dragon.getName() + " level up to " + dragon.getLevel());
    }

    public static void feeding(Dragon dragon) {
        int feed = dragon.getFeed();
        if (Data.player.getPlayer().getFood() >= dragon.getReqFood()) {
            dragon.setFeed(feed + 1);
            Data.player.getPlayer().setFood(Data.player.getPlayer().getFood() - dragon.getReqFood());
            if (dragon.getFeed() >= 5) {
                dragon.setFeed(0);
                levelUp(dragon);
            }
            Data.view.feedDragon(dragon);
        } else {
            Data.game.print("Food not enough");
        }
    }

}
