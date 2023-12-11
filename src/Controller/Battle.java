// Battle.java
package src.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.Node.Data.*;
import src.View.Game;
import src.Node.Data.Element;

public class Battle {
    private ArrayList<Dragon> player;
    private ArrayList<Dragon> bot;
    private boolean playerTurn;

    public Battle(ArrayList<Dragon> player, ArrayList<Dragon> bot) {
        this.player = player;
        this.bot = bot;
        this.playerTurn = new Random().nextBoolean(); // TODO: Randomize starting turn - change into mini game high /
                                                      // low dice
        setBattleHP(player);
        setBattleHP(bot);
    }

    private void setBattleHP(ArrayList<Dragon> dragons) {
        dragons.forEach(dragon -> dragon.setBattleHP(dragon.getHP()));
    }

    private boolean isAlive(ArrayList<Dragon> dragons) {
        return dragons.stream().anyMatch(d -> d.getBattleHP() > 0);
    }

    private ArrayList<Integer> aliveDragonIndices(ArrayList<Dragon> dragons) {
        ArrayList<Integer> aliveIndices = new ArrayList<>();
        int index = 0;
        for (Dragon dragon : dragons) {
            if (dragon.getBattleHP() > 0) {
                aliveIndices.add(index);
            }
            index++;
        }
        return aliveIndices;
    }

    // FIXME: fix battle logic
    public void startBattle() {
        System.out.println(playerTurn ? "Player's Turn" : "Bot's Turn");
        Dragon attacker = playerTurn ? selectDragon("player", player) : selectDragon("bot", bot);
        Dragon defender = playerTurn ? selectDragon("bot", bot) : selectDragon("player", player);

        int turn = 1;

        while (isAlive(player) && isAlive(bot)) {

            if (turn % 2 == 0) {
                Game.cls();
            }

            attack(attacker, defender);
            switchTurn();
            turn++;

            System.out.println(playerTurn ? "Player's Turn" : "Bot's Turn");

            attacker = playerTurn ? selectDragon("player", player) : selectDragon("bot", bot);
            defender = playerTurn ? selectDragon("bot", bot) : selectDragon("player", player);
        }

        displayBattleResult();
    }

    private Dragon selectDragon(String who, ArrayList<Dragon> dragons) {
        List<String> listDragon = new ArrayList<>();
        ArrayList<Integer> aliveDragonIndices = aliveDragonIndices(dragons);

        int selectedDragon;
        if (who.equals("player")) {
            selectedDragon = Data.input.getMenuUserInput("Select Dragon", listDragon.toArray(new String[0])) - 1;
        } else {
            selectedDragon = aliveDragonIndices.get(new Random().nextInt(aliveDragonIndices.size()));
        }

        return dragons.get(selectedDragon);
    }

    private void takeDamage(Dragon dragon, int damage) {
        int currentHP = dragon.getBattleHP();
        int newHP = currentHP - damage;
        dragon.setBattleHP(newHP);
    }

    private void attack(Dragon attacker, Dragon defender) {
        Skill dragonSkill = chooseSkill(attacker);

        int damage = calculateDamage(attacker.getElement(), defender.getElement(), dragonSkill.getDamage());
        takeDamage(defender, damage);

        displayBattleInfo(attacker, dragonSkill, defender, damage);
    }

    private Skill chooseSkill(Dragon dragon) {
        Random random = new Random();
        ArrayList<Skill> skills = dragon.getAllSkills();
        int randomIndex = random.nextInt(skills.size());
        return dragon.getSkill(randomIndex);
    }

    private int calculateDamage(Element attackerElement, Element defenderElement, int damage) {
        double damageMultiplier;
        switch (attackerElement.compare(defenderElement)) {
            case "weak":
                damageMultiplier = 0.5; // Weak: Causes only half damage (50%)
                break;
            case "normal":
                damageMultiplier = 1.0; // No damage
                break;
            case "strong":
                damageMultiplier = 2.0; // Strong: Causes double damage (200%)
                break;
            default:
                damageMultiplier = 0.0; // Normal: Causes normal damage (100%)
        }
        return (int) (damage * damageMultiplier);
    }

    private void switchTurn() {
        playerTurn = !playerTurn;
    }

    private void displayBattleInfo(Dragon attacker, Skill skill, Dragon defender, int damage) {
        System.out.println(attacker.getName() + " uses " + skill.getName() +
                " against " + defender.getName() + " and deals " + damage + " damage!");
        System.out.println(defender.getName() + " has " + defender.getBattleHP() + " HP remaining.\n");
        int hp = (int) ((float) defender.getBattleHP() / defender.getHP() * 100);
        System.out.println(("=").repeat(hp / 10) + ("_").repeat(10 - (hp / 10)) + " " + hp + "%");
    }

    private void displayBattleResult() {
        if (!isAlive(player)) {
            System.out.println("Game Over! " + Data.player.getAccount().getNickname() + " has been defeated.");
        } else if (!isAlive(bot)) {
            System.out.println("Congratulations! You have defeated the bot.");
        } else {
            System.out.println("The battle ended in a draw.");
        }
    }
}
