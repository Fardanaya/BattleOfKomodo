// Battle.java
package src.Controller;

import src.Node.Data.*;
import src.View.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Thread;

public class Battle {
    private List<Dragon> player;
    private List<Dragon> bot;
    private boolean playerTurn;

    public Battle(List<Dragon> player, List<Dragon> bot) {
        this.player = prepareDragons(player);
        this.bot = prepareDragons(bot);
        this.playerTurn = new Random().nextBoolean();
    }

    private List<Dragon> prepareDragons(List<Dragon> dragons) {
        List<Dragon> newDragons = new ArrayList<>();
        for (Dragon dragon : dragons) {
            Dragon clonedDragon = dragon.clone();
            clonedDragon.setBattleHP(clonedDragon.getHP());
            newDragons.add(clonedDragon);
        }
        return newDragons;
    }

    private boolean isAlive(List<Dragon> dragons) {
        return dragons.stream().anyMatch(d -> d.getBattleHP() > 0);
    }

    private List<Integer> aliveDragonIndices(List<Dragon> dragons) {
        List<Integer> aliveIndices = new ArrayList<>();
        for (int i = 0; i < dragons.size(); i++) {
            if (dragons.get(i).getBattleHP() > 0) {
                aliveIndices.add(i);
            }
        }
        return aliveIndices;
    }

    public void startBattle() { // FIXME: BUG DRAGON THAT TAKING DAMAGE
            // TODO: add validation for draw match, if player and bot only have dragon with same element id. 
        System.out.println(playerTurn ? "Player's Turn" : "Bot's Turn");

        while (isAlive(player) && isAlive(bot)) {
            if (!playerTurn) {
                System.out.println("Enemy Attacking ...");
                try {
                    Thread.sleep((new Random().nextInt(3)) * 1000);
                } catch (Exception e) {
                    System.out.println();
                }
            }

            Dragon attacker = selectDragon(playerTurn ? "player" : "bot", playerTurn ? player : bot);
            Dragon defender = selectDragon(playerTurn ? "bot" : "player", playerTurn ? bot : player);

            attack(attacker, defender);
            switchTurn();
        }

        displayBattleResult();
    }

    private Dragon selectDragon(String who, List<Dragon> dragons) {
        List<Integer> aliveDragonIndices = aliveDragonIndices(dragons);

        ArrayList<String> listAlive = new ArrayList<>();
        if (aliveDragonIndices.size() > 0) {
            for (Dragon dragon : dragons) {
                if (dragon.getBattleHP() > 0) {
                    listAlive.add(dragon.getName());
                }
            }
        }

        if (who.equals("player") && playerTurn) {
            return dragons.get(Data.input.getMenuUserInput("Select Dragon", listAlive.toArray(new String[0])) - 1);
        } else {
            return dragons.get(aliveDragonIndices.get(new Random().nextInt(aliveDragonIndices.size())));
        }
    }

    private void takeDamage(Dragon dragon, int damage) {
        int currentHP = dragon.getBattleHP();
        dragon.setBattleHP(Math.max(0, currentHP - damage));
    }

    private void attack(Dragon attacker, Dragon defender) {
        Skill dragonSkill = chooseSkill(attacker);
        int damage = calculateDamage(attacker.getElement(), defender.getElement(), dragonSkill.getDamage());
        takeDamage(defender, damage);

        displayBattleInfo(attacker, dragonSkill, defender, damage);
    }

    private Skill chooseSkill(Dragon dragon) {
        List<Skill> skills = dragon.getAllSkills();
        return skills.get(new Random().nextInt(skills.size()));
    }

    private int calculateDamage(Element attackerElement, Element defenderElement, int damage) {
        double damageMultiplier = attackerElement.compare(defenderElement);

        return (int) (damage * damageMultiplier);
    }

    private void switchTurn() {
        playerTurn = !playerTurn;
        System.out.println(playerTurn ? "Player's Turn" : "Bot's Turn");
    }

    private void displayBattleInfo(Dragon attacker, Skill skill, Dragon defender, int damage) {
        System.out.println(attacker.getName() + " uses " + skill.getName() +
                " against " + defender.getName() + " and deals " + damage + " damage!");
        System.out.println(defender.getName() + " has " + defender.getBattleHP() + " HP remaining.\n");

        new Game().HUD(player, bot);
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
