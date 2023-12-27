package src.Controller.Modul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.Controller.Data;
import src.Node.Data.Bot;
import src.Node.Data.Dragon;

public class Battle {
    private static final int TEAM_SIZE_PERCENTAGE_3 = 85;
    private static final int TEAM_SIZE_PERCENTAGE_2 = 10;
    private static final int TEAM_SIZE_PERCENTAGE_1 = 5;

    public ArrayList<Dragon> generateBotTeam() {
        ArrayList<Dragon> botTeam = new ArrayList<>();

        int randomPercentage = new Random().nextInt(100) + 1;

        int teamSize;
        if (randomPercentage <= TEAM_SIZE_PERCENTAGE_1) {
            teamSize = 1;
        } else if (randomPercentage <= TEAM_SIZE_PERCENTAGE_1 + TEAM_SIZE_PERCENTAGE_2) {
            teamSize = 2;
        } else {
            teamSize = 3;
        }

        for (int i = 0; i < teamSize; i++) {
            int random = new Random().nextInt(Data.dragonList.getAllDragons().size());
            Dragon dragon = Data.dragonList.getDragon(random);
            botTeam.add(dragon);
        }

        return botTeam;
    }
}
