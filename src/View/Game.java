package src.View;

import java.io.IOException;
import java.util.List;

import src.Controller.Data;
import src.Node.Data.*;

public class Game {
    public void alert(String message) {
        System.out.println("[ Game ] " + message);
    }

    public void print(String message) {
        System.out.println(message);
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
        sb.append(String.format(usernameFormat, centerText(Data.player.getPlayer().getNickname(), 33),
                centerText("BOT", 33)));
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
        System.out.println(attacker.getName() + " uses " + skill.getName() + " against " + defender.getName()
                + " and deals " + damage + " damage!");
        System.out.println(defender.getName() + " has " + defender.getBattleHP() + " HP remaining.\n");
    }

    public void displayBattleResult(String status, String playerName, String botName, String time, int reward, Battle player,
            Battle bot) {

        StringBuilder sb = new StringBuilder();
        sb.append("+-----------------------------------------------------------------------------+\n");
        if (status.equals("win")) {
            sb.append(centerText("Congratulations! You have defeated " + botName + ".\n", 75));
        } else if (status.equals("lose")) {
            sb.append(centerText("Game Over! " + Data.player.getPlayer().getNickname() + " has been defeated.\n", 75));
        } else {
            sb.append(centerText("The battle ended in a draw.", 75));
        }
        sb.append(centerText("Total time elapsed : " + time + "\n", 75));
        sb.append(centerText("Total reward : " + reward + " coins \n", 75));

        String dragonFormat = "| %-32s          %-32s |%n";
        sb.append("+----------------------------------+      +----------------------------------+\n");
        sb.append(String.format(dragonFormat, centerText(playerName, 32), centerText(botName, 32)));
        sb.append("+----------------------------------+      +----------------------------------+\n");
        sb.append(String.format(dragonFormat, centerText("Damage Dealed - " + player.getDamageDealed(), 32),
                centerText("Damage Dealed - " + bot.getDamageDealed(), 32)));
        sb.append(String.format(dragonFormat, centerText("Damage Taken - " + player.getDamageTaken(), 32),
                centerText("Damage Taken - " + bot.getDamageTaken(), 32)));
        sb.append("+----------------------------------+      +----------------------------------+\n");
        System.out.println(sb.toString());
    }

    public void turn(boolean playerTurn) {
        if (playerTurn) {
            System.out.println("Player's Turn!");
        } else {
            System.out.println("Bot's Turn!");
        }
    }

    public int selectSkill(List<String> availableSkills) {
        return Data.prompt.getMenuUserInput("Choose Skill", availableSkills.toArray(new String[0]));
    }

    public String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return String.format("%" + (padding + text.length()) + "s", text);
    }
}
