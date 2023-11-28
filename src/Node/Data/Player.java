package src.Node.Data;

public class Player {
    private String nickname;
    private String username;
    private String password;

    // TODO ARRAYLIST DRAGON
    private Dragon dragon;

    public Player(String username, String password) {
        this.nickname = "Player";
        this.username = username;
        this.password = password;
    }

    public Player(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    
    // TODO: NOT COMPLETE
    // public void addDragonToPlayer(Dragon originalDragon) {
    //     this.dragon = originalDragon;
    // }
}