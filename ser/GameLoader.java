import java.io.*;

public class GameLoader {

    public static void main(String[] args) {

        GameCharacter oneRestored = null;
        GameCharacter twoRestored = null;
        GameCharacter threeRestored = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("/home/pacmanface/projects/headFirst/ser/MyGame.ser"));
            oneRestored = (GameCharacter) is.readObject();
            twoRestored = (GameCharacter) is.readObject();
            threeRestored = (GameCharacter) is.readObject();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(oneRestored);
        System.out.println(twoRestored);
        System.out.println(threeRestored);
    }
}
