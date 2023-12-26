package src.Controller.Modul;

import src.Controller.Data;

public class Deck {

    public void addDragonToDeck() {
        if (Data.player.getPlayer().getDeck().size() < 3) {
            Data.game.print("Add Dragon");
            int id = Integer.parseInt(Data.prompt.getUserInput("ID Naga : "));
            if (Data.player.getPlayer().getDeck().contains(id)) {
                Data.game.print("Naga sudah ada di deck");
            } else {
                Data.player.getPlayer().addDragonToDeck(id);
            }
        } else {
            Data.game.print("Change Dragon");
            int oldId = Integer.parseInt(Data.prompt.getUserInput("Dragon ID yang ingin ditukar : "));
            if (Data.player.getPlayer().getDeck().contains(oldId)) {
                int newId = Integer.parseInt(Data.prompt.getUserInput("Dragon ID yang ingin dimasukkan : "));
                if (Data.player.getPlayer().getDeck().contains(newId)) {
                    Data.game.print("Naga sudah ada di deck");
                } else {
                    Data.player.getPlayer().removeDragonFromDeck(oldId);
                    Data.player.getPlayer().addDragonToDeck(newId);
                }
            } else {
                Data.game.print("Naga tidak ada di deck");
            }
        }
    }

    public void removeDragonFromDeck() {
        Data.player.getPlayer()
                .removeDragonFromDeck(Integer.parseInt(Data.prompt.getUserInput("Remove Dragon Slot :")) - 1);
    }

    public void repositionDragon() {
        Data.game.print("Reposition Dragon");
        int oldPosition = Integer.parseInt(Data.prompt.getUserInput("Dragon Slot : "));
        
        if (oldPosition > 0 && oldPosition <= Data.player.getPlayer().getDeck().size()) {
            int newPosition = Integer.parseInt(Data.prompt.getUserInput("New Dragon Slot : "));
            
            if (newPosition > 0 && newPosition <= Data.player.getPlayer().getDeck().size()
                    && newPosition != oldPosition) {
                
                int oldDragon = Data.player.getPlayer().getDeck().get(oldPosition - 1);
                int newDragon = Data.player.getPlayer().getDeck().get(newPosition - 1);
                
                Data.player.getPlayer().getDeck().set(oldPosition - 1, newDragon);
                Data.player.getPlayer().getDeck().set(newPosition - 1, oldDragon);
            } else {
                Data.game.print("Slot tidak valid");
            }
        }
    }
    
    

    public void clearDeck() {
        Data.player.getPlayer().clearDeck();
    }
}
