package src.Controller;

import src.Controller.Modul.*;
import src.Controller.Modul.Battle;
import src.Node.Data.*;

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
                        user.getPlayer().addDragonToPlayer(Data.dragonList.getAllDragons().get(0).clone());
                        user.getPlayer().addDragonToPlayer(Data.dragonList.getAllDragons().get(1).clone());
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
                    battle();
                    break;
                case 2:
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
        Deck deck = new Deck();
        do {
            Data.view.showBattleDeckDragon(Data.player.getPlayer().getAllDragon(), Data.player.getPlayer().getDeck());
            selectedOption = Data.menu.deckMenu();
            switch (selectedOption) {
                case 1:
                    deck.addDragonToDeck();
                    break;
                case 2:
                    deck.removeDragonFromDeck();
                    break;
                case 3:
                    deck.repositionDragon();
                    break;
                case 4:
                    deck.clearDeck();
                    break;
                case 5:
                    // exit
                    break;
                default:
                    return;
            }
        } while (selectedOption != 5);
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
                    Data.view.showAllDragon(Data.player.getPlayer().getAllDragon());
                    break;
                case 2:
                    int i;
                    while (true) {
                        try {
                            i = Integer.parseInt(Data.prompt.getUserInput("Pilih ID Naga : ")) - 1;
                            if (i >= 0 && i < Data.player.getPlayer().getAllDragon().size()) {
                                break;
                            } else {
                                Data.game.print("ID Naga tidak valid");
                            }
                        } catch (NumberFormatException e) {
                            Data.game.print("ID Naga harus berupa angka");
                        }
                    }
                    Data.view.showDragonDetails(Data.player.getPlayer().getDragon(i));
                    break;
                case 3:
                    return;
            }
        } while (selectedOption != 3);
    }
    
    public void battle() {
        if (Data.player.getPlayer().getDeck().size() < 1) {
            Data.game.print("You need at least 1 dragon in your deck to battle");
            return;
        }
        
        Battle battleModule = new Battle();
        BattleController battle = new BattleController(Data.player.getPlayer().battleDragons(), new Bot(battleModule.generateBotTeam()).battleDragons());
        battle.startBattle();
    }

}
