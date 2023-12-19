package src.Controller;

import java.util.ArrayList;
import src.Node.Data.*;

public class DragonController {
    public void checkLevelUp(ArrayList<Dragon> dragons){
        for (Dragon dragon : dragons) {
            
        }
    }

    public void levelUp(Dragon dragon){
        if (dragon.getExperience() >= dragon.getReqExperience()){
            dragon.setLevel(dragon.getLevel()+1);
            dragon.setReqExperience(dragon.getReqExperience()+(100*dragon.getLevel()));
        }
    }
}
