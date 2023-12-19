package src.Node.Data;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String nickname;
    private int level = 1;
    private int coin = 1000;
    private int food = 500;
    private int exp = 0;

    private ArrayList<Dragon> dragon;
    private ArrayList<Dragon> deck;

    public Player() {
        this.dragon = new ArrayList<>();
        this.deck = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getFood(){
        return food;
    }

    public void setFood(int food){
        this.food = food;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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

    public ArrayList<Dragon> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Dragon> deck) {
        this.deck = deck;
    }

    public void addDragonToDeck(Dragon Dragon) {
        this.deck.add(Dragon);
    }

    public void removeDragonFromDeck(int id) {
        this.deck.remove(id);
    }

    public void clearDeck() {
        this.deck.clear();
    }

    public List<Dragon> battleDragons() {
        List<Dragon> BattleDeck = new ArrayList<>();

        for (Dragon dragon : this.deck) {
            Dragon clonedDragon = dragon.clone();
            clonedDragon.setBattleHP(clonedDragon.getHP());
            BattleDeck.add(clonedDragon);
        }

        return BattleDeck;
    }
}
