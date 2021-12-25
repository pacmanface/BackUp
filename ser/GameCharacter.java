import java.io.Serializable;

public class GameCharacter implements Serializable{
    String power;
    String type;
    String[] weapons;

    public GameCharacter(String power, String type, String[] weapons){
        this.type = type;
        this.power = power;
        this.weapons = weapons;
    }

    String getPower(){
        return power;
    }

    String getType(){
        return type;
    }

    String getWeapons(){
        String res = "";
            for (String s : weapons) {
                res += s;
            }
        return res;
    }
    
}
