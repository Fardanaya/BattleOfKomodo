package src.View;

import java.util.ArrayList;

import src.Node.Data.*;

public class viewData {

    // player
    public void showPlayerDetails(Player player) {
        System.out.println("Nickname : " + player.getAccount().getNickname());
        System.out.println("Username : " + player.getUsername());
        System.out.println(
                "Password : " + player.getPassword().substring(0, 1) + ("*").repeat(player.getPassword().length() - 2)
                        + player.getPassword().substring(player.getPassword().length() - 1));
    }

    public void showAllPlayerDetails(ArrayList<Player> playerList) {
        for (Player player : playerList) {
            System.out.println("========================");
            showPlayerDetails(player);
        }
        System.out.println("========================");
    }

    // Dragon
    public void showDragonDetails(Dragon dragon) {
        System.out.println("Dragon ID : " + dragon.getId());
        System.out.println("Dragon Name : " + dragon.getName());
        System.out.println("Dragon Level : " + dragon.getLevel());
        // System.out.println("Dragon Attack : " + dragon.getAttack());
        // System.out.println("Dragon Defense : " + dragon.getDefense());
        System.out.println("Dragon Current HP : " + dragon.getBattleHP());
        System.out.println("Dragon Max HP : " + dragon.getMaxHP());
        System.out.println("Dragon Experience : " + dragon.getExperience());
        System.out.println("Dragon Element : ");
        System.out.println("   Element : " + dragon.getElement().getName());
        System.out.println("   Weakness : " + dragon.getElement().getWeak());
        System.out.println("   Strength : " + dragon.getElement().getStrong());
        System.out.println("Dragon Age Stage : ");
        System.out.println("   Age : " + dragon.getAgeStage().getStageName());
    }

    public void showDragon(Dragon dragon) {
        System.out.println("Dragon ID : " + dragon.getId());
        System.out.println("Dragon Name : " + dragon.getName());
        System.out.println("Dragon Element : " + dragon.getElement().getName());
    }

    public void showAllDragonDetails(ArrayList<Dragon> dragonList) {
        for (Dragon dragon : dragonList) {
            System.out.println("========================");
            showDragonDetails(dragon);
        }
        System.out.println("========================");
    }

    public void showAllDragon(ArrayList<Dragon> dragonList) {
        for (Dragon dragon : dragonList) {
            System.out.println("========================");
            showDragon(dragon);
        }
        System.out.println("========================");
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
