package src.Node.Data;

public class Skill {
    public int id;
    public String name;
    public int startPoint;

    public Skill(int id, String name, int startPoint){
        this.id = id;
        this.name = name;
        this.startPoint = startPoint;
    }

    // TODO: incerment (start point) damage for leveling

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getStartPoint(){
        return startPoint;
    }

}