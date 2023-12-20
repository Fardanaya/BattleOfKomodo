package src.View;

import src.Controller.UserController;

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

    public int mainMenu() {
        String title = "Main Menu";
        String[] Menu = { "Tarung", "Feeding", "Deck", "Zoo", "Market", "Logout" };

        int selectedOption = menu.getMenuUserInput(title, Menu);
        Game.cls();

        return selectedOption;
    }

    public int feed() {
        String title = "Feeding Menu";
        String[] Menu = { "1x", "Multiple", "Kembali" };

        int selectedOption = menu.getMenuUserInput(title, Menu);
        Game.cls();
        return selectedOption;

    }

    public void zoo() {
        System.out.println("===ZOO===");
        // FIXME : METHOD CHANGED
    }

    public void market() {
        System.out.println("===MARKET===");
        // TODO call func for print all komodo that available in market
    }

    public int deckMenu() {
        String title = "Main Menu";
        String[] Menu = { "Tambah / Ubah", "Hapus", "Reset Deck", "Kembali" };

        int selectedOption = menu.getMenuUserInput(title, Menu);
        Game.cls();

        return selectedOption;
    }

}