import src.Controller.*;
import src.View.*;

import src.testing;

public class Main {
    public static void main(String[] args) {

        // PREPARING THE GAME...
        Data model = new Data();
        model.Complete();
        Setup setup = new Setup();
        setup.Complete();
        Game.cls();
        // SUCCESSFULLY LOADED...

        // TESTING
        // testing.test();

        // PROGRAM
        UserController user = new UserController();
        user.userAuth();
        
        // viewData playermenu = new viewData();
        // playermenu.showPlayerDetails(Data.player);;

        // SAVING DATA TO JSON FILE
        Data.skillList.saveData();
        Data.dragonList.saveData();
        Data.playerList.saveData();
    }
}