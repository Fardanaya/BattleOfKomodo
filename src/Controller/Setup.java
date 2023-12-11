package src.Controller;

import src.Node.Data.Age;
import src.Node.Data.Dragon;
import src.Node.Data.Element;
import src.Node.Data.Player;
import src.Node.Data.Skill;
import src.View.Message;

public class Setup {

    private Message gameMessage = new Message();

    public Setup() {

        setupElement();
        setupAge();
        setupSkill();

        // setupDragon(); // TODO : SEKALI SAJA KLO BELUM ADA DATA
        // testSetupPlayer(); // TODO : SEKALI SAJA KLO BELUM ADA DATA
    }

    private void setupElement() {
        Data.element.addElement(new Element("fire", "Fire", "water", "nature"));
        Data.element.addElement(new Element("water", "Water", "nature", "fire"));
        Data.element.addElement(new Element("nature", "Nature", "fire", "water"));
    }

    private void setupAge() {
        Data.age.addAge(new Age("egg", "Egg"));
        Data.age.addAge(new Age("baby", "Baby"));
        Data.age.addAge(new Age("young", "Muda"));
        Data.age.addAge(new Age("adult", "Dewasa"));
    }

    private void setupDragon() {
        Data.dragonList.addDragon(new Dragon("volcanodragon", "Flame Dragon", 1, 1, 1, 1,
                Data.element.getElement(Data.element.searchElement("fire")),
                Data.age.getAge(Data.age.searchAge("egg"))));

        Data.dragonList.addDragon(new Dragon("icedragon", "Ice Dragon", 1, 1, 1, 1,
                Data.element.getElement(Data.element.searchElement("water")),
                Data.age.getAge(Data.age.searchAge("egg"))));

        Data.dragonList.addDragon(new Dragon("tropicaldragon", "Tropical Dragon", 1, 1, 1, 1,
                Data.element.getElement(Data.element.searchElement("nature")),
                Data.age.getAge(Data.age.searchAge("egg"))));

    }

    public void setupSkill() {
        Data.skillList.addSkill(new Skill(0, "Fireball", 5));
        Data.skillList.addSkill(new Skill(1, "Flood", 7));
    }

    public void testSetupPlayer() {
        Data.playerList.addPlayer(new Player("admin", "admin"));
    }
    
    public void Complete() {
        gameMessage.alert("Successfully Load Data !");
    }
}
