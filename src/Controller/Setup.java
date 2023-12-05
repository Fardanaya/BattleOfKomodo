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
        Model.element.addElement(new Element("fire", "Fire", "water", "nature"));
        Model.element.addElement(new Element("water", "Water", "nature", "fire"));
        Model.element.addElement(new Element("nature", "Nature", "fire", "water"));
    }

    private void setupAge() {
        Model.age.addAge(new Age("egg", "Egg"));
        Model.age.addAge(new Age("baby", "Baby"));
        Model.age.addAge(new Age("young", "Muda"));
        Model.age.addAge(new Age("adult", "Dewasa"));
    }

    private void setupDragon() {
        Model.dragonList.addDragon(new Dragon("volcanodragon", "Flame Dragon", 1, 1, 1, 1,
                Model.element.getElement(Model.element.searchElement("fire")),
                Model.age.getAge(Model.age.searchAge("egg"))));

        Model.dragonList.addDragon(new Dragon("icedragon", "Ice Dragon", 1, 1, 1, 1,
                Model.element.getElement(Model.element.searchElement("water")),
                Model.age.getAge(Model.age.searchAge("egg"))));

        Model.dragonList.addDragon(new Dragon("tropicaldragon", "Tropical Dragon", 1, 1, 1, 1,
                Model.element.getElement(Model.element.searchElement("nature")),
                Model.age.getAge(Model.age.searchAge("egg"))));

    }

    public void setupSkill() {
        Model.skillList.addSkill(new Skill(0, "Fireball", 5));
        Model.skillList.addSkill(new Skill(1, "Flood", 7));
    }

    public void testSetupPlayer() {
        Model.playerList.addPlayer(new Player("admin", "admin"));
    }
    
    public void Complete() {
        gameMessage.alert("Successfully Load Data !");
    }
}
