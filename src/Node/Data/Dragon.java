package src.Node.Data;

import java.util.ArrayList;

public class Dragon {
    // TODO : SKILL , ELEMEN , AGE

    private String id;
    private String name;
    private int level = 0;
    private int battleHP = 0;
    private int HP = 0;
    private int maxHP = 0;
    private int feed = 0;
    private int reqFood = 100;
    private Element element;
    private Age age;

    private ArrayList<Skill> skills = new ArrayList<>();

    public Dragon(String id, String name, Element element, Age age) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.age = age;
    }

    public Dragon(String id, String name, int level, int HP, int maxHP, int feed, int reqFood, Element element,
            Age age) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.maxHP = maxHP;
        this.feed = feed; //jumlah makanan yang termakan
        this.reqFood = reqFood; //makanan yang dibutuhkan buat up level
        this.element = element;
        this.age = age;
    }

    // CLONING
    public Dragon(String id, String name, int level, int HP, int maxHP, int feed, int reqFood, Element element, Age age,
            ArrayList<Skill> skills) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.element = element;
        this.HP = HP;
        this.maxHP = maxHP;
        this.feed = feed;
        this.reqFood = reqFood;
        this.age = age;
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Element getElement() {
        return element;
    }

    public int getBattleHP() {
        return battleHP;
    }

    public int getHP() {
        return HP;
    }

    public void setBattleHP(int battleHP) {
        this.battleHP = battleHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getFeed() {
        return feed;
    }

    public void setFeed(int feed) {
        this.feed = feed;
    }

    public int getReqFood() {
        return reqFood;
    }

    public void setReqFood(int reqFood) {
        this.reqFood = reqFood;
    }

    public Age getAgeStage() {
        return age;
    }

    public ArrayList<Skill> getSkill() {
        return skills;
    }

    public void setSkill(ArrayList<Skill> skills) {
        this.skills = skills;
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

    public Dragon clone() {
        return new Dragon(this.id,
                this.name,
                this.level,
                this.HP,
                this.maxHP,
                this.feed,
                this.reqFood,
                this.element,
                this.age,
                this.skills);
    }
}
