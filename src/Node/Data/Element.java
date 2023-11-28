package src.Node.Data;

public class Element {
    private String name;
    private int weakness;
    private int strength;

    public Element(String name, int weakness, int strength) {
        this.name = name;
        this.weakness = weakness;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getWeakness() {
        return weakness;
    }

    public int getStrength() {
        return strength;
    }

    public static Element valueOf(String string) {
        return null;
    }
}
