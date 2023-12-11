package src.Controller;

public class User {
    public void userAuth(int selectedOption) {
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
    }
}
