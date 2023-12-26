package src.View;

import java.util.ArrayList;
import java.util.List;

import src.Node.Data.*;

public class viewData {

    // player
    public void showPlayerDetails(Account player) {
        System.out.println("Nickname : " + player.getPlayer().getNickname());
        System.out.println("Username : " + player.getUsername());
        System.out.println(
                "Password : " + player.getPassword().substring(0, 1) + ("*").repeat(player.getPassword().length() - 2)
                        + player.getPassword().substring(player.getPassword().length() - 1));
    }

    public void showAllPlayerDetails(ArrayList<Account> playerList) {
        for (Account player : playerList) {
            System.out.println("========================");
            showPlayerDetails(player);
        }
        System.out.println("========================");
    }

    // Dragon
    public void showDragonDetails(Dragon dragon) {
        System.out.println("Name : " + dragon.getName());
        System.out.println("Level : " + dragon.getLevel());
        System.out.println("HP : " + dragon.getHP() + " / " + dragon.getMaxHP());
        System.out.println("Element : " + dragon.getElement().getName());
        System.out.println("- Weakness : " + String.join(", ", dragon.getElement().getWeak()));
        System.out.println("- Strength : " + String.join(", ", dragon.getElement().getStrong()));
        System.out.println("Age : " + dragon.getAgeStage().getStageName());
        System.out.println("Dragon Skill : ");
        System.out.print("- Skill : ");
        for (Skill skill : dragon.getSkill()) {
            System.out.print(skill.getName());
            if (dragon.getSkill().indexOf(skill) == dragon.getSkill().size() - 1) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }

    public void showAllDragonDetails(ArrayList<Dragon> dragonList) {
        for (Dragon dragon : dragonList) {
            System.out.println("========================");
            showDragonDetails(dragon);
        }
        System.out.println("========================");
    }

    public void showAllDragon(ArrayList<Dragon> dragonList) {
        if (dragonList.size() == 0) {
            System.out.println("No Dragon Found");
            return;
        }

        String format = "| %-2s | %-20s | %-9s | %-5s |%n";
        System.out.println("+----+----------------------+-----------+-------+");
        System.out.format(format, "ID", "Dragon Name", "Element", "level");
        System.out.println("+----+----------------------+-----------+-------+");
        for (Dragon dragon : dragonList) {
            System.out.format(format, dragonList.indexOf(dragon) + 1, dragon.getName(), dragon.getElement().getName(),
                    dragon.getLevel());
        }
        System.out.println("+----+----------------------+-----------+-------+");
    }

    public void showBattleDeckDragon(ArrayList<Dragon> dragonList, List<Integer> battleDeck) {
        if (battleDeck.isEmpty()) {
            System.out.println("Battle Deck is Empty");
            return;
        }

        String format = "| %-4s |  | %-2s | %-20s | %-9s | %-5s |%n";
        System.out.println("+------+  +----+----------------------+-----------+-------+");
        System.out.format(format, "Slot", "ID", "Dragon Name", "Element", "Level");
        System.out.println("+------+  +----+----------------------+-----------+-------+");

        for (int deckId : battleDeck) {
            int index = deckId - 1;
            if (index >= 0 && index < dragonList.size()) {
                Dragon dragon = dragonList.get(index);
                System.out.format(format, battleDeck.indexOf(deckId) + 1, index + 1, dragon.getName(),
                        dragon.getElement().getName(),
                        dragon.getLevel());
            }
        }

        System.out.println("+------+  +----+----------------------+-----------+-------+");
    }

    public void feedDragon(Dragon dragon) {
        String format = "| %-20s | %-5s | %-5s |%n";
        System.out.println("+----------------------+-------+-------+");
        System.out.format(format, "Dragon Name", "Level", "Feed");
        System.out.println("+----------------------+-------+-------+");
        System.out.format(format, dragon.getName(), dragon.getLevel(), "0".repeat(dragon.getFeed()));
        System.out.println("+----------------------+-------+-------+");
    }

    // Element

    public void showElementDetails(Element element) {
        System.out.println("Element ID   : " + element.getId());
        System.out.println("Element Name : " + element.getName());
        System.out.println("Element Weakness : " + element.getWeak());
        System.out.println("Element Strength : " + element.getStrong());
    }

    public void showElement(Element element) {
        System.out.println("Element ID : " + element.getId());
        System.out.println("Element Name : " + element.getName());
    }

    public void showAllElementDetails(ArrayList<Element> elementList) {
        for (Element element : elementList) {
            System.out.println("========================");
            showElementDetails(element);
        }
        System.out.println("========================");
    }

    public void showAllElement(ArrayList<Element> elementList) {
        for (Element element : elementList) {
            System.out.println("========================");
            showElement(element);
        }
        System.out.println("========================");
    }

    // Skill
    public void showSkillDetails(Skill skill) {
        System.out.println("Skill ID : " + skill.getId());
        System.out.println("Skill Name : " + skill.getName());
        System.out.println("Skill Base Power : " + skill.getDamage());
    }

    public void showSkill(Skill skill) {
        System.out.println("Skill Name : " + skill.getName());
        System.out.println("Skill Damage : " + skill.getDamage());
    }

    public void showAllSkillDetails(ArrayList<Skill> skillList) {
        for (Skill skill : skillList) {
            System.out.println("========================");
            showSkillDetails(skill);
        }
        System.out.println("========================");
    }

    public void showAllSkill(ArrayList<Skill> skillList) {
        for (Skill skill : skillList) {
            System.out.println("========================");
            showSkill(skill);
        }
        System.out.println("========================");
    }

    // Age
    public void showAgeDetails(Age age) {
        System.out.println("Age ID   : " + age.getId());
        System.out.println("Age Stage Name : " + age.getStageName());
    }

    public void showAllAgeDetails(ArrayList<Age> ageList) {
        for (Age age : ageList) {
            System.out.println("========================");
            showAgeDetails(age);
        }
        System.out.println("========================");
    }
}
