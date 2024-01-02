// Battle.java
package src.Controller;

import src.Controller.Modul.Time;
import src.Node.Data.*;
import src.View.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.*;
import java.lang.Thread;

public class BattleController {
    private Battle player;
    private Battle bot;
    private boolean playerTurn;

    Time time;

    public BattleController(List<Dragon> player, List<Dragon> bot) {
        this.player = new Battle(Data.player.getPlayer().getNickname(), player);
        this.bot = new Battle("BOT", bot);

        this.playerTurn = new Random().nextBoolean();

        this.time = new Time();
    }

    private boolean isAlive(List<Dragon> dragons) {
        return dragons.stream().anyMatch(d -> d.getBattleHP() > 0);
    }

    private List<Integer> aliveDragonIndices(List<Dragon> dragons) {
        return IntStream.range(0, dragons.size())
                .filter(i -> dragons.get(i).getBattleHP() > 0)
                .boxed()
                .collect(Collectors.toList());
    }

    private int calculateReward() {
        double percentage = 0;
        long timeInSeconds = time.time() / 1000;

        if (timeInSeconds < 30) {
            percentage += 0.10;
        } else if (timeInSeconds < 60) {
            percentage += 0.05;
        }

        if (player.getDamageTaken() < bot.getDamageTaken() && player.getDamageDealed() > bot.getDamageDealed()) {
            percentage += 0.10;
        } else if (player.getDamageDealed() > bot.getDamageDealed()) {
            percentage += 0.05;
        }

        int coin = 0;
        int level = 0;
        int dragonsSize = player.getDragons().size();
        for (Dragon dragon : player.getDragons()) {
            level += dragon.getLevel();
        }
        double rata_level = level / (double) dragonsSize;

        if (rata_level > 10) {
            coin += (1000 + (1000 * percentage));
        } else if (rata_level > 5) {
            coin += (500 + (500 * percentage));
        } else {
            coin += (250 + (250 * percentage));
        }

        coin += (player.getDamageDealed() - player.getDamageTaken());

        return coin;
    }

    public int startBattle() {
        while (isAlive(player.getDragons()) && isAlive(bot.getDragons())) {
            if (!playerTurn) {
                Game.cls();
                System.out.println("Enemy Attacking ...");
                try {
                    Thread.sleep((new Random().nextInt(3)) * 1000);
                } catch (Exception e) {
                    System.out.println();
                }
            }

            Dragon attacker = selectDragon(playerTurn ? "player" : "bot",
                    playerTurn ? player.getDragons() : bot.getDragons());
            Dragon defender = selectDragon(playerTurn ? "bot" : "player",
                    playerTurn ? bot.getDragons() : player.getDragons());

            attack(attacker, defender);
            Data.game.HUD(player, bot);
            switchTurn();
        }

        int reward = calculateReward();
        battleResult(reward);
        return reward;
    }

    private Dragon selectDragon(String who, List<Dragon> dragons) {
        List<Integer> aliveDragonIndices = aliveDragonIndices(dragons);

        ArrayList<String> listAlive = new ArrayList<>();
        if (aliveDragonIndices.size() > 0) {
            for (Dragon dragon : dragons) {
                if (dragon.getBattleHP() > 0) {
                    listAlive.add(dragon.getName());
                } else {
                    listAlive.add(dragon.getName() + " [dead]");
                }
            }
        }

        if (who.equals("player") && playerTurn) {
            do {
                int pilih = Data.prompt.getMenuUserInput("Select Dragon", listAlive.toArray(new String[0])) - 1;
                if (aliveDragonIndices.contains(pilih)) {
                    Dragon naga = dragons.get(pilih);
                    return naga;
                } else {
                    continue;
                }
            } while (true);
        } else {
            return dragons.get(aliveDragonIndices.get(new Random().nextInt(aliveDragonIndices.size())));
        }
    }

    private void takeDamage(Dragon dragon, int damage) {
        int currentHP = dragon.getBattleHP();
        dragon.setBattleHP(Math.max(0, currentHP - damage));
    }

    private void attack(Dragon attacker, Dragon defender) {
        Skill dragonSkill = playerTurn ? chooseSkill(attacker) : chooserandomSkill(attacker);

        int damage = calculateDamage(attacker.getElement(), defender.getElement(), dragonSkill.getDamage());

        if (playerTurn) {
            player.setDamageDealed(player.getDamageDealed() + damage);
            bot.setDamageTaken(bot.getDamageTaken() + damage);
        } else {
            bot.setDamageDealed(bot.getDamageDealed() + damage);
            player.setDamageTaken(player.getDamageTaken() + damage);
        }

        takeDamage(defender, damage);
        Data.game.displayBattleInfo(attacker, dragonSkill, defender, damage);
    }

    private Skill chooserandomSkill(Dragon dragon) {
        List<Skill> skills = dragon.getAllSkills();
        return skills.get(new Random().nextInt(skills.size()));
    }

    private Skill chooseSkill(Dragon dragon) {
        List<Skill> skills = dragon.getAllSkills();
        int choose;
        do {
            List<String> availableSkills = new ArrayList<>();
            for (Skill skill : skills) {
                if (skills.get(skills.indexOf(skill)).getTreshold() <= dragon.getLevel()) {
                    availableSkills.add(skill.getName());
                } else {
                    availableSkills.add(skill.getName() + " [locked]");
                }
            }

            choose = (Data.game.selectSkill(availableSkills));
            if (choose >= 1 && choose <= skills.size() && skills.get(choose - 1).getTreshold() > dragon.getLevel()) {
                System.out.println("Skill terkunci. Pilih skill lain.");
            }
        } while (choose < 1 || choose > skills.size() || (skills.get(choose - 1).getTreshold() > dragon.getLevel()));
        return skills.get(choose - 1);
    }

    private int calculateDamage(Element attackerElement, Element defenderElement, int damage) {
        double damageMultiplier = attackerElement.compare(defenderElement);

        return (int) (damage * damageMultiplier);
    }

    private void switchTurn() {
        playerTurn = !playerTurn;
        Data.game.turn(playerTurn);
    }

    private String battleResult(int reward) {
        String result = "draw";
        if (isAlive(player.getDragons()) && !isAlive(bot.getDragons())) {
            result = "win";
        } else if (!isAlive(player.getDragons()) && isAlive(bot.getDragons())) {
            result = "lose";
        }
        Data.game.displayBattleResult(result, player.getNickname(), bot.getNickname(), time.battleTime(), reward,
                this.player,
                this.bot);
        return result;
    }
}
