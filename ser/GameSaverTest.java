import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter("50","elf",new String[]{"sword","bow","knife"});
        GameCharacter two = new GameCharacter("200","ork",new String[]{"fists","dubina"});
        GameCharacter three = new GameCharacter("120","magicman",new String[]{"zaklinaniya","nevidimost"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/home/pacmanface/Downloads/MyGame.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        } catch (Exception e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("/home/pacmanface/Downloads/MyGame.ser"));
            GameCharacter oneRestored = (GameCharacter) is.readObject();
            GameCharacter twoRestored = (GameCharacter) is.readObject();
            GameCharacter threeRestored = (GameCharacter) is.readObject();

            System.out.println(oneRestored.getType());
            System.out.println(twoRestored.getType());
            System.out.println(threeRestored.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
