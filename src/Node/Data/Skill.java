package src.Node.Data;

public class Skill {
    public int id;
    public String name;
    public int damage;
    public int treshold;
    public boolean unlock;

    public Skill(int id, String name, int damage, int treshold){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.treshold = treshold;
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

    public boolean isUnlock(int lev){
        if(lev >= treshold){
            return this.unlock = true;
        }else{
            return this.unlock = false;
        }
    }

}