// Battle.java
package src.Node.Data;

import java.util.Random;

public class Battle {
    private Dragon player;
    private int maxPlayerHP;

    private Dragon bot;
    private int maxBotHP;

    private boolean playerTurn;

    public Battle(Dragon player, Dragon bot) {
        this.player = player;
        this.bot = bot;
        this.playerTurn = true;

        this.maxPlayerHP = player.getCurrentHP();
        this.maxBotHP = bot.getCurrentHP();
    }

    private boolean isAlive(Dragon dragon) {
        return dragon.getCurrentHP() > 0;
    }

    public void startBattle() {
        while (isAlive(player) && isAlive(bot)) {
            if (playerTurn) {
                playerAttack();
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

    private void playerAttack() {
        Skill playerSkill = chooseSkill(player);

        int damage = calculateDamage(player.getElement(), bot.getElement(), playerSkill.getDamage());

        takeDamage(bot, damage);

        displayBattleInfo(player, playerSkill, bot, damage);
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
            System.out.println("Game Over! " + player.getName() + " has been defeated.");
        } else if (!isAlive(bot)) {
            System.out.println("Congratulations! You have defeated the bot.");
        } else {
            System.out.println("The battle ended in a draw.");
        }
    }
}
