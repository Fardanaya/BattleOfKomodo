package src.Node.Data;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String nickname;
    private int coin = 1000;
    private int food = 500;

    private ArrayList<Dragon> dragon;
    private ArrayList<Integer> deck;

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

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
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

    public ArrayList<Integer> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Integer> deck) {
        this.deck = deck;
    }

    public void addDragonToDeck(int Dragon) {
        this.deck.add(Dragon);
    }

    public void removeDragonFromDeck(int id) {
        this.deck.remove(id);
    }

    public void clearDeck() {
        this.deck.clear();
    }

    public List<Dragon> battleDragons() {
        ArrayList<Dragon> battleDeck = new ArrayList<>();

        for (Integer index : this.deck) {
            int adjustedIndex = index - 1;
            if (index >= 0 && adjustedIndex < this.dragon.size()) {
                Dragon dragon = this.dragon.get(adjustedIndex);
                Dragon clonedDragon = dragon.clone();
                clonedDragon.setBattleHP(clonedDragon.getHP());
                battleDeck.add(clonedDragon);
            }
        }

        return battleDeck;
    }

}
