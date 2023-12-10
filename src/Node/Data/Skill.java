package src.Node.Data;

public class Skill {
    public int id;
    public String name;
    public int damage;

    public Skill(int id, String name, int damage){
        this.id = id;
        this.name = name;
        this.damage = damage;
    }

    // TODO: incerment (start point) damage for leveling

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

}