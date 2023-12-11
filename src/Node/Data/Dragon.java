package src.Node.Data;

import java.util.ArrayList;

import com.google.gson.JsonElement;

public class Dragon {
    // TODO : SKILL , ELEMEN , AGE

    private String id;
    private String name;
    private int level;
    private int currentHP;
    private int HP;
    private int maxHP;
    private int experience;
    private Element element;
    private Age age;
    private Skill skill;

    private ArrayList<Skill> skills = new ArrayList<>();

    public Dragon(String id, String name, int level, int HP,
            int maxHP, int experience, Element element, Age age) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.element = element;
        this.HP = HP;
        this.maxHP = maxHP;
        this.experience = experience;
        this.age = age;
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

    public int getCurrentHP() {
        return currentHP;
    }
    
    public int getHP() {
        return HP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getExperience() {
        return experience;
    }

    public Age getAgeStage() {
        return age;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill(int index) {
        return skills.get(index);
    }

    public ArrayList<Skill> getAllSkills() {
        return skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    // public void updateSkill(int index, Skill skill) {
    // this.skills.set(index, skill);
    // }

}
