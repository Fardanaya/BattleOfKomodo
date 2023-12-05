package src.View;

import java.util.ArrayList;

import src.Node.Data.Player;

public class playerView {

    public void showPlayerDetails(Player player) {
        System.out.println("Nickname : " + player.getNickname());
        System.out.println("Username : " + player.getUsername());
        System.out.println(
                "Password : " + player.getPassword().substring(0, 1) + ("*").repeat(player.getPassword().length() - 2)
                        + player.getPassword().substring(player.getPassword().length() - 1));
    }

    public void showAllPlayerDetails(ArrayList<Player> playerList) {
        for (Player player : playerList) {
            System.out.println("========================");
            showPlayerDetails(player);
        }
        System.out.println("========================");
    }
}
