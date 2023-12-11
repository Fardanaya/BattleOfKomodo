package src.View;

import java.util.ArrayList;
import src.Node.Data.Dragon;

public class DragonView {
    public void showDragonDetails(Dragon dragon) {
        System.out.println("Dragon ID : " + dragon.getId());
        System.out.println("Dragon Name : " + dragon.getName());
        System.out.println("Dragon Level : " + dragon.getLevel());
        // System.out.println("Dragon Attack : " + dragon.getAttack());
        // System.out.println("Dragon Defense : " + dragon.getDefense());
        System.out.println("Dragon Current HP : " + dragon.getBattleHP());
        System.out.println("Dragon Max HP : " + dragon.getMaxHP());
        System.out.println("Dragon Experience : " + dragon.getExperience());
        System.out.println("Dragon Element : ");
        System.out.println("   Element : " + dragon.getElement().getName());
        System.out.println("   Weakness : " + dragon.getElement().getWeakness());
        System.out.println("   Strength : " + dragon.getElement().getStrength());
        System.out.println("Dragon Age Stage : ");
        System.out.println("   Age : " + dragon.getAgeStage().getStageName());
    }

    public void showDragon(Dragon dragon) {
        System.out.println("Dragon ID : " + dragon.getId());
        System.out.println("Dragon Name : " + dragon.getName());
        System.out.println("Dragon Element : " + dragon.getElement().getName());
    }

    public void showAllDragonDetails(ArrayList<Dragon> dragonList) {
        for (Dragon dragon : dragonList) {
            System.out.println("========================");
            showDragonDetails(dragon);
        }
        System.out.println("========================");
    }

    public void showAllDragon(ArrayList<Dragon> dragonList) {
        for (Dragon dragon : dragonList) {
            System.out.println("========================");
            showDragon(dragon);
        }
        System.out.println("========================");
    }
}
