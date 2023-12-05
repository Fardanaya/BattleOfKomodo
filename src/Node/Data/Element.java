package src.Node.Data;

public class Element {
    private String id;
    private String name;
    private String weakness;
    private String strength;

    public Element(String id, String name, String weakness, String strength) {
        this.id = id;
        this.name = name;
        this.weakness = weakness;
        this.strength = strength;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeakness() {
        return weakness;
    }

    public String getStrength() {
        return strength;
    }
}
