import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter("50","elf",new String[]{"sword","bow","knife"});
        GameCharacter two = new GameCharacter("200","ork",new String[]{"fists","dubina"});
        GameCharacter three = new GameCharacter("120","magicman",new String[]{"zaklinaniya","nevidimost"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("MyGame.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;
    }
}
