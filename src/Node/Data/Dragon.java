package src.Node.Data;

public class Dragon {
    // TODO : SKILL , ELEMEN , AGE

    private String id;
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int currentHP;
    private int maxHP;
    private int experience;
    private Element element;
    private AgeStage ageStage;

    public Dragon(String id, String name, int level, int attack, int defense, int currentHP,
            int maxHP, int experience, Element element, AgeStage ageStage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.element = element;
        this.attack = attack;
        this.defense = defense;
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

    public Dragon cloneDragon() {
        Dragon clonedDragon = new Dragon(this.id, this.name, this.level, this.attack, this.defense,
                this.currentHP, this.maxHP, this.experience, this.element, this.ageStage);
        return clonedDragon;
    }
}
