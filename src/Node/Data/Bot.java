package src.Node.Data;

import java.util.ArrayList;

public class Bot {
    private ArrayList<Dragon> dragon = new ArrayList<>();
        
    public Bot(ArrayList<Dragon> dragon) {
        this.dragon = dragon;
    }

    public ArrayList<Dragon> battleDragons() {
        ArrayList<Dragon> BattleDeck = new ArrayList<>();

        for (Dragon dragon : this.dragon) {
            Dragon clonedDragon = dragon.clone();
            clonedDragon.setBattleHP(clonedDragon.getHP());
            BattleDeck.add(clonedDragon);
        }

        return BattleDeck;
    }
}
