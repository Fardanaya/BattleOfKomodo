package src.Controller;

import java.util.ArrayList;

import src.Controller.Modul.Auth;
import src.Node.Data.*;
import src.View.Input;

public class UserController {

    public void userAuth() {
        Auth auth = new Auth();
        while (Data.getPlayer() == null) {
            int selectedOption = Data.menu.userAuth();
            switch (selectedOption) {
                case 1:
                    auth.register();
                    break;
                case 2:
                    Account user = auth.login();
                    if (user.getPlayer().getNickname() == null) {
                        String nickname = Data.prompt.getUserInput("Buat Nickname Anda : ");
                        while (nickname.isEmpty()) {
                            nickname = Data.prompt.getUserInput("Buat Nickname Anda : ");
                        }
                        user.getPlayer().setNickname(nickname);
                    }
                    Data.setPlayer(user);
                    userMenu();
                    Data.setPlayer(null);
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

    public void userMenu() {
        int selectedOption;
        do {
            selectedOption = Data.menu.mainMenu();
            switch (selectedOption) {
                case 1:
                    // battle
                    break;
                case 2:
                    // Feed
                    feeding();
                    break;
                case 3:
                    userDeck();
                    break;
                case 4:
                    userZoo();
                    break;
                case 5:
                    // market / shop
                    break;
                case 6:
                    // exit
                    break;
                default:
                    return;
            }
        } while (selectedOption != 6);
    }

    public void userDeck() {
        int selectedOption;
        do {
            Data.view.showAllDragon((ArrayList<Dragon>) Data.player.getPlayer().battleDragons());
            selectedOption = Data.menu.deckMenu();
            switch (selectedOption) {
                case 1:
                    if (Data.player.getPlayer().getDeck().size() < 3) {
                        Data.game.print("Add Dragon");
                        int id = Integer.parseInt(Data.prompt.getUserInput("ID Naga : "));
                        if (Data.player.getPlayer().getDeck().contains(id - 1)) {
                            Data.game.print("Naga sudah ada di deck");
                        } else {
                            Data.player.getPlayer().addDragonToDeck(id - 1);
                        }
                    } else {
                        Data.game.print("Change Dragon"); // TODO Swap ID Dragon on Battledeck
                    }
                    break;
                case 2:
                    Data.player.getPlayer().removeDragonFromDeck(Integer.parseInt(Data.prompt.getUserInput("Remove Dragon ID :")) - 1); // DONE
                    break;
                case 3:
                    Data.player.getPlayer().clearDeck(); // DONE
                    break;
                case 4:
                    // exit
                    break;
                default:
                    return;
            }
        } while (selectedOption != 4);
    }

    public void feeding() {
        do {
            Data.view.showAllDragon(Data.player.getPlayer().getAllDragon());
            int pilih = Integer.parseInt(Data.prompt.getUserInput("Pilih Dragon: "));
            Dragon dragon = Data.player.getPlayer().getDragon(pilih - 1);
            while (true) {
                int selectedOption = Data.menu.feed();
                switch (selectedOption) {
                    case 1:
                        DragonController.feeding(dragon);
                        break;
                    case 2:
                        int repeat = Integer.parseInt(Data.prompt.getUserInput("Berapa Kali : "));
                        for (int i = 0; i < repeat; i++) {
                            DragonController.feeding(dragon);
                        }
                        break;
                    case 3:
                        return;
                }
            }
        } while (true);
    }

    public void userZoo() {
        int selectedOption;
        do {
            selectedOption = Data.menu.zoo();
            switch (selectedOption) {
                case 1:
                    // lihat semua
                    Data.view.showAllDragon(Data.player.getPlayer().getAllDragon());
                    break;
                case 2:
                    // lihat 1 aja
                    
                    int i;
                    while (true) {
                        try {
                            i = Integer.parseInt(Data.prompt.getUserInput("Pilih ID Naga : "))-1;
                            if (i >= 0 && i < Data.player.getPlayer().getAllDragon().size()) {
                                break; // Keluar dari loop jika input valid
                            } else {
                                System.out.println("DATA TIDAK DITEMUKAN");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Input harus berupa angka");
                        }
                    }
                    Data.view.showDragonDetails(Data.player.getPlayer().getDragon(i));
                    break;
                case 3:
                    return;
            }
        } while (selectedOption != 3);
    }

}
