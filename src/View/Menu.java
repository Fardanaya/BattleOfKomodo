package src.View;

import src.Controller.Model;

public class Menu {

    public void mainMenu()  {
        System.out.println("===MAIN MENU===");
        String[] Menu = {"Tarung", "Latih", "Zoo", "Market", "Keluar"};
        ArrowMenu arrowMenu = new ArrowMenu(Menu);
        int selectedOption = arrowMenu.runMenu();
        System.out.println("Selected option : " + selectedOption);
    }

    public void latih(){
        System.out.println("===LATIH===");
        // Model.dragonList.showDragonList(); // FIXME : METHOD CHANGED
        // TODO dijadikan selector
    }

    public void zoo(){
        System.out.println("===ZOO===");
        // Model.dragonList.showDragonList(); // FIXME : METHOD CHANGED
        // TODO dijadikan selector
    }

    public void market(){
        System.out.println("===MARKET===");
        // TODO call func for print all komodo that available in market
    }
}