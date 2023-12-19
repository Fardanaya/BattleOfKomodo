package src.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.Controller.Data;
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

    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return String.format("%" + (padding + text.length()) + "s", text);
    }

    private String getHPBar(int currentHP, int maxHP) {
        int percentage = (int) Math.floor((double) currentHP / maxHP * 100);
        int oCount = percentage / 10;
        String hpBar = "   Dead   ";
        if (oCount > 0) {
            hpBar = "O".repeat(oCount);
        }
        return hpBar;
    }

    public void HUD(Battle player, Battle bot) {
        StringBuilder sb = new StringBuilder();

        sb.append("+-----------------------------------+            +-----------------------------------+\n");
        String usernameFormat = "| %-33s |            | %-33s |%n";
        sb.append(String.format(usernameFormat, centerText(Data.player.getPlayer().getNickname(), 33), centerText("BOT", 33)));
        sb.append("+----------------------+------------+            +------------+----------------------+\n");

        String dragonFormat = "| %-20s | %-10s |            | %10s | %-20s |%n";
        for (int i = 0; i < 3; i++) {
            Dragon playerDragon = (player.getDragons().size() > i) ? player.getDragons().get(i) : null;
            Dragon botDragon = (bot.getDragons().size() > i) ? bot.getDragons().get(i) : null;

            String playerName = (playerDragon != null) ? playerDragon.getName() : "";
            String playerHP = (playerDragon != null) ? getHPBar(playerDragon.getBattleHP(), playerDragon.getHP()) : "";
            String botHP = (botDragon != null) ? getHPBar(botDragon.getBattleHP(), botDragon.getHP()) : "";
            String botName = (botDragon != null) ? botDragon.getName() : "";

            sb.append(String.format(dragonFormat, playerName, playerHP, botHP, botName));
        }
        sb.append("+----------------------+------------+            +------------+----------------------+\n");
        System.out.println(sb.toString());
    }

    public static void displayDragonSkills(Dragon dragon) {
        List<Skill> skills = dragon.getAllSkills();
        System.out.println("Choose Skill: ");
        int index = 1;
        for (Skill skill : skills) {
            System.out.println("[" + index + "] " + skill.getName());
            index++;
        }
    }

    public void displayBattleInfo(Dragon attacker, Skill skill, Dragon defender, int damage) {
        System.out.println(attacker.getName() + " uses " + skill.getName() + " against " + defender.getName() + " and deals " + damage + " damage!");
        System.out.println(defender.getName() + " has " + defender.getBattleHP() + " HP remaining.\n");
    }

    public void displayBattleResult(String status, String playerName, String botName) {
        if (status.equals("win")) {
            System.out.println("Congratulations! You have defeated " + botName + ".");
        } else if (status.equals("lose")) {
            System.out.println("Game Over! " + Data.player.getPlayer().getNickname() + " has been defeated.");
        } else {
            System.out.println("The battle ended in a draw.");
        }
    }

    public void turn(boolean playerTurn) {
        if (playerTurn) {
            System.out.println("Player's Turn!");
        } else {
            System.out.println("Bot's Turn!");
        }
    }

    public int selectSkill(List<String> availableSkills) {
        return Data.input.getMenuUserInput("Choose Skill", availableSkills.toArray(new String[0]));
    }
}
