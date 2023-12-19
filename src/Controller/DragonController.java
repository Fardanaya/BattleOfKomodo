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
        System.out.println("Dragon " + dragon.getName() + " level up to " + dragon.getLevel());
    }

    public static void feeding(Dragon dragon) {
        int feed = dragon.getFeed();
        dragon.setFeed(feed + 1);
        // TODO : CONNECT USER FOOD
        if (dragon.getFeed() >= 5) {
            dragon.setFeed(0);
            levelUp(dragon);
        }
        System.out.println("Dragon " + dragon.getName() + dragon.getFeed() + "/" + 5); // TODO : MOVE VIEW
    }

}
