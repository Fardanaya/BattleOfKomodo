package src.Node.Data;

import java.util.ArrayList;
import java.util.Arrays;

public class Element {
    private String id;
    private String name;
    private ArrayList<String> weak;
    private ArrayList<String> strong;

    public Element(String id, String name, String[] weak, String[] strong) {
        this.id = id;
        this.name = name;
        this.weak = new ArrayList<>(Arrays.asList(weak));
        this.strong = new ArrayList<>(Arrays.asList(strong));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getWeak() {
        return weak;
    }

    public ArrayList<String> getStrong() {
        return strong;
    }

    // Battle System
    public String compare(Element opponent) {
        if (opponent.getWeak().contains(this.getName())) {
            return "weak";
        } else if (opponent.getStrong().contains(this.getName())) {
            return "strong";
        } else if (opponent.getId().equals(this.getId())) {
            return "nothing";
        } else {
            return "normal";
        }
    }
    
}
