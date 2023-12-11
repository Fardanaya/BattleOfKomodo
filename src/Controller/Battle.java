// Battle.java
package src.Controller;

import java.util.ArrayList;
import java.util.Random;

import src.Node.Data.Dragon;
import src.Node.Data.Element;
import src.Node.Data.Skill;

public class Battle {
    private ArrayList<Dragon> player;
    private ArrayList<Dragon> bot;

    private boolean playerTurn;

    public Battle(ArrayList<Dragon> player, ArrayList<Dragon> bot) {
        this.player = player;
        this.bot = bot;
        this.playerTurn = true; //TODO : mini game coin which one play first, make a funct to randomize it
        setCurrentHP(player);
        setCurrentHP(bot);
    }

    private void setCurrentHP(ArrayList<Dragon> nagas) {
        for(Dragon dragon: nagas){
            dragon.setCurrentHP(dragon.getHP());
        }
    }

    private boolean isAlive(ArrayList<Dragon> dragon) {
        for (Dragon d : dragon) {
            if (d.getCurrentHP() > 0) {
                return true;
            }
        }
        return false;
    }
    public void startBattle() {
        while (isAlive(player) && isAlive(bot)) {
            if (playerTurn) {
                // TODO: call dragon selector
                playerAttack(dragon);
            } else {
                botAttack();
            }
            switchTurn();
        }
        displayBattleResult();
    }

    private void takeDamage(Dragon dragon, int damage) {
        int currentHP = dragon.getCurrentHP();
        int newHP = currentHP - damage;
        dragon.setCurrentHP(newHP);
        ;
    }

    private void playerAttack(Dragon dragon, Dragon bot) {
        Skill dragonSkill = chooseSkill(dragon);

        int damage = calculateDamage(dragon.getElement(), bot.getElement(), dragonSkill.getDamage());

        takeDamage(bot, damage);

        displayBattleInfo(dragon, dragonSkill, bot, damage);
    }

    private void botAttack() {
        Skill botSkill = chooseSkill(bot);

        int damage = calculateDamage(bot.getElement(), player.getElement(), botSkill.getDamage());

        takeDamage(player, damage);

        displayBattleInfo(bot, botSkill, player, damage);
    }

    private Skill chooseSkill(Dragon dragon) {
        Random random = new Random();
        int randomIndex = random.nextInt(dragon.getAllSkills().size());
        return dragon.getSkill(randomIndex);
    }

    private int calculateDamage(Element attackerElement, Element defenderElement, int damage) {
        // Menghitung kerusakan berdasarkan hubungan elemen
        double damageMultiplier;

        if (defenderElement.isWeakAgainst(attackerElement)) {
            damageMultiplier = 0.5; // Weak: Causes only half damage (50%)
        } else if (defenderElement.isStrongAgainst(attackerElement)) {
            damageMultiplier = 2.0; // Strong: Causes double damage (200%)
        } else {
            damageMultiplier = 1.0; // Normal: Causes normal damage (100%)
        }

        System.out.println(damageMultiplier);

        return (int) (damage * damageMultiplier);
    }

    private void switchTurn() {
        playerTurn = !playerTurn;
    }

    private void displayBattleInfo(Dragon attacker, Skill skill, Dragon defender, int damage) {
        System.out.println(attacker.getName() + " uses " + skill.getName() +
                " against " + defender.getName() + " and deals " + damage + " damage!");
        System.out.println(defender.getName() + " has " + defender.getCurrentHP() + " HP remaining.\n");
    }

    private void displayBattleResult() {
        if (!isAlive(player)) {
            System.out.println("Game Over! " + Model.player.getNickname() + " has been defeated.");
        } else if (!isAlive(bot)) {
            System.out.println("Congratulations! You have defeated the bot.");
        } else {
            System.out.println("The battle ended in a draw.");
        }
    }
}
