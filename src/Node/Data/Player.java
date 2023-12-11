package src.Node.Data;

import java.util.ArrayList;

public class Player {
    private String username;
    private String password;
    private Account account;
    private ArrayList<Dragon> dragon;

    // register
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.dragon = new ArrayList<>();
        this.account = new Account();
    }

    // login
    public Player(String username, String password, Account account, ArrayList<Dragon> dragon) {
        this.username = username;
        this.password = password;
        this.account = account;
        this.dragon = dragon;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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