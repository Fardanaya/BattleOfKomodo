package src.Node.Data;

public class Player {

    private String username;
    private String password; 
    //TODO ARRAYLIST DRAGON
    private Dragon dragon;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}