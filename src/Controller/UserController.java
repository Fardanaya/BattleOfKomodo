package src.Controller;

import src.Controller.Modul.Auth;
import src.Node.Data.*;
import src.View.*;

public class UserController {

    Menu menu = new Menu();
    Game game = new Game();
    viewData view = new viewData();

    public void userAuth() {
        Auth auth = new Auth();
        while (Data.getPlayer() == null) {
            int selectedOption = menu.userAuth();
            switch (selectedOption) {
                case 1:
                    auth.register();
                    break;
                case 2:
                    Account user = auth.login();
                    if (user.getPlayer().getNickname() == null) {
                        String nickname = Data.input.getUserInput("Buat Nickname Anda : ");
                        while (nickname.isEmpty()) {
                            nickname = Data.input.getUserInput("Buat Nickname Anda : ");
                        }
                        user.getPlayer().setNickname(nickname);
                    }
                    Data.setPlayer(user);
                    userMenu();
                    Data.setPlayer(null);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public void userMenu() {
        int selectedOption;
        do {
            selectedOption = menu.mainMenu();
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
                    view.showAllDragon(Data.player.getPlayer().getAllDragon()); // DONE
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
            view.showAllDragon(Data.player.getPlayer().getDeck());
            selectedOption = menu.deckMenu();
            // viewData view = new viewData();
            switch (selectedOption) {
                case 1:
                    // add klo naga < 3 / change klo naga == 3
                    if (Data.player.getPlayer().getAllDragon().size() < 3) {
                        game.print("Add Dragon");

                        // add
                    } else {
                        // change ( id to id )
                    }
                    break;
                case 2:
                    Data.player.getPlayer()
                            .removeDragonFromDeck(Integer.parseInt(Data.input.getUserInput("Remove Dragon ID :")) - 1); // DONE
                    break;
                case 3:
                    // reset deck ( clear )
                    Data.playerList.getAccount(Data.playerList.searchAccount(Data.player.getUsername())).getPlayer()
                            .clearDeck(); // DONE
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
            view.showAllDragon(Data.player.getPlayer().getAllDragon());
            int pilih = Integer.parseInt(Data.input.getUserInput("Pilih Dragon: "));
            Dragon dragon = Data.playerList.getAccount(Data.playerList.searchAccount(Data.player.getUsername()))
                    .getPlayer().getDragon(pilih - 1);
            while (true) {
                int selectedOption = menu.feed();
                switch (selectedOption) {
                    case 1:
                        DragonController.feeding(dragon);
                        break;
                    case 2:
                        int repeat = Integer.parseInt(Data.input.getUserInput("Berapa Kali : "));
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
}
