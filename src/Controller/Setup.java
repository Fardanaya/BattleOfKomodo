package src.Controller;

import src.Node.Data.Age;
import src.Node.Data.Dragon;
import src.Node.Data.Element;
import src.Node.Data.Market;
import src.Node.Data.Account;
import src.Node.Data.Skill;
import src.View.Game;

public class Setup {

        private Game gameMessage = new Game();

        public Setup() {

                // SAVED INTO MEMORY
                setupElement();
                setupAge();
                // setupMarket();
                // setupSkill();

                // setupDragon(); // TODO : SEKALI SAJA KLO BELUM ADA DATA
                // testSetupPlayer(); // TODO : SEKALI SAJA KLO BELUM ADA DATA
        }

        private void setupElement() {
                Data.element.addElement(
                                new Element(
                                                "flame",
                                                "Flame",
                                                new String[] { "water" },
                                                new String[] { "nature", "ice" }));

                Data.element.addElement(
                                new Element(
                                                "water",
                                                "Water",
                                                new String[] { "nature", "electric" },
                                                new String[] { "fire" }));

                Data.element.addElement(
                                new Element(
                                                "nature",
                                                "Nature",
                                                new String[] { "fire", "ice" },
                                                new String[] { "water" }));

                Data.element.addElement(
                                new Element("earth",
                                                "Earth",
                                                new String[] {},
                                                new String[] { "electric" }));

                Data.element.addElement(
                                new Element("electric",
                                                "Electric",
                                                new String[] { "earth" },
                                                new String[] { "water" }));

                Data.element.addElement(
                                new Element("ice",
                                                "Ice",
                                                new String[] { "fire" },
                                                new String[] { "nature" }));
        }

        private void setupAge() {
                Data.age.addAge(new Age("egg", "Egg"));
                Data.age.addAge(new Age("baby", "Baby"));
                Data.age.addAge(new Age("young", "Muda"));
                Data.age.addAge(new Age("adult", "Dewasa"));
        }

        private void setupDragon() {
                Data.dragonList.addDragon(new Dragon("volcanodragon", "Flame Dragon",
                                Data.element.getElement(Data.element.searchElement("flame")),
                                Data.age.getAge(Data.age.searchAge("egg"))));

                Data.dragonList.addDragon(new Dragon("icedragon", "Ice Dragon",
                                Data.element.getElement(Data.element.searchElement("ice")),
                                Data.age.getAge(Data.age.searchAge("egg"))));

                Data.dragonList.addDragon(new Dragon("tropicaldragon", "Tropical Dragon",
                                Data.element.getElement(Data.element.searchElement("nature")),
                                Data.age.getAge(Data.age.searchAge("egg"))));
        }

        // private void setupMarket() {
        //         Data.marketList.addMarket(new Market(100, ));
        // }

        public void setupSkill() {
                Data.skillList.addSkill(new Skill(0, "Fireball", 5, 0));
                Data.skillList.addSkill(new Skill(1, "Flood", 7, 0));
                Data.skillList.addSkill(new Skill(2, "Earthquake", 6, 0));
        }

        public void testSetupPlayer() {
                Data.playerList.addAccount(new Account("admin", "admin"));
        }

        public void Complete() {
                gameMessage.alert("Successfully Load Data !");
        }
}
