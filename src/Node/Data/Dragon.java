package src.Node.Data;

public class Dragon {
    // TODO : SKILL , ELEMEN , AGE

    private String id;
    private String name;
    private int level;
    private Element element;
    private int attack;
    private int defense;
    private int speed;
    private int currentHP;
    private int maxHP;
    private int experience;
    private AgeStage ageStage;

    public Dragon(String id, String name, int level, Element element, int attack, int defense, int speed, int currentHP,
            int maxHP, int experience, AgeStage ageStage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.element = element;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.experience = experience;
        this.ageStage = ageStage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Element getElement() {
        return element;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getExperience() {
        return experience;
    }

    public AgeStage getAgeStage() {
        return ageStage;
    }

}
