package src.View;

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

    public int zoo() {
        String title = "ZOO";
        String[] Menu = { "Lihat semua naga", "lihat naga", "Kembali" };
        int selectedOption = menu.getMenuUserInput(title, Menu);
        Game.cls();
        return selectedOption;
    }

    public int market() {
        String title = "MARKET";
        String[] Menu = { "Naga", "Berry", "Kembali" };
        int selectedOption = menu.getMenuUserInput(title, Menu);
        Game.cls();
        return selectedOption;
    }

    public int deckMenu() {
        String title = "Main Menu";
        String[] Menu = { "Tambah / Ubah", "Hapus","Reposition", "Reset Deck", "Kembali" };
        int selectedOption = menu.getMenuUserInput(title, Menu);
        Game.cls();
        return selectedOption;
    }

}