package src.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.Node.Data.*;

public class Game {
    public void alert(String message) {
        System.out.println("[ Game ] " + message);
    }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    public void HUD(List<Dragon> player, List<Dragon> bot) {
        String leftAlignFormat = "| %-20s | %-10s |      | %-10s | %-20s |%n";
        System.out.format("+----------------------+------------+      +------------+----------------------+%n");
        for (int i = 0; i < player.size(); i++) {
            System.out.format(leftAlignFormat, player.get(i).getName(),
                    player.get(i).getBattleHP(),
                    bot.get(i).getBattleHP(), bot.get(i).getName());
        }
        System.out.format("+----------------------+------------+      +------------+----------------------+%n");

    }
}
