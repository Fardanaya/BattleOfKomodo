package src.Node.Data;

public class Account {
    private String username;
    private String password;
    private Player player;

    // register
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.player = new Player();
    }

    // login
    public Account(String username, String password, Player player) {
        this.username = username;
        this.password = password;
        this.player = player;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}