package src.Node.Data;

import java.util.List;

public class Battle {
    private String nickname;
    private double damageDealed;
    private double damageTaken;
    private List<Dragon> dragons;

    public Battle(String nickname, List<Dragon> dragons) {
        this.nickname = nickname;
        this.damageDealed = 0;
        this.damageTaken = 0; // TODO: Change this to each dragon ??? 
        this.dragons = dragons;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getDamageDealed() {
        return damageDealed;
    }

    public void setDamageDealed(double damageDealed) {
        this.damageDealed = damageDealed;
    }

    public double getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(double damageTaken) {
        this.damageTaken = damageTaken;
    }

    public List<Dragon> getDragons() {
        return dragons;
    }
}
