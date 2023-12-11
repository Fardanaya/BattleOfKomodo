package src.Controller;

import src.View.*;

public class User {
    public void userAuth() {

        Menu menu = new Menu();
        do {
            int selectedOption = menu.userAuth();

            Auth auth = new Auth();
            switch (selectedOption) {
                case 1:
                    auth.register();
                    break;
                case 2:
                    Data.setPlayer(auth.login());
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (Data.getPlayer() == null);
    }
}
