package src.View;

import src.Controller.User;

public class Menu {

    private Input menu;

    public Menu() {
        this.menu = new Input();
    }

    public int userAuth() {
        String title = "Welcome to Dragon Game";
        String[] Menu = { "Register", "Login", "Keluar" };

        int selectedOption = menu.getMenuUserInput(title, Menu);
        Game.cls();

        return selectedOption;
    }

    public void mainMenu() {
        String title = "Main Menu";
        String[] Menu = { "Tarung", "Latih", "Zoo", "Market", "Keluar" };

        int selectedOption = menu.getMenuUserInput(title, Menu);

        System.out.println("Selected option : " + selectedOption);
    }

    public void latih() {
        System.out.println("===LATIH===");
        // Model.dragonList.showDragonList(); // FIXME : METHOD CHANGED
        // TODO dijadikan selector
    }

    public void zoo() {
        System.out.println("===ZOO===");
        // Model.dragonList.showDragonList(); // FIXME : METHOD CHANGED
        // TODO dijadikan selector
    }

    public void market() {
        System.out.println("===MARKET===");
        // TODO call func for print all komodo that available in market
    }
}