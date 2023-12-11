package src.Node.Data;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private String username;
    private String password;

    // TODO ARRAYLIST DRAGON
    private ArrayList<Dragon> dragon = new ArrayList<>();
    
    // register
    public Player(String username, String password) {
        this.nickname = "Player";
        this.username = username;
        this.password = password;
    }

    // new player
    public Player(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    // login
    public Player(String nickname, String username, String password, ArrayList<Dragon> dragon) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.dragon = dragon;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int searchDragon(String name) {
        for (int i = 0; i < dragon.size(); i++) {
            if (dragon.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Dragon getDragon(int index) {
        return dragon.get(index);
    }

    public ArrayList<Dragon> getAllDragon() {
        return dragon;
    }

    public void addDragonToPlayer(Dragon Dragon) {
        this.dragon.add(Dragon);
    }

    public void updateDragon(int index, Dragon Dragon) {
        this.dragon.set(index, Dragon);
    }

    public void removeDragonFromPlayer(Dragon Dragon) {
        this.dragon.remove(Dragon);
    }
}