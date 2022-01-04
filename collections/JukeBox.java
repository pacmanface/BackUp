import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class JukeBox {
    
    ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        JukeBox songMachine = new JukeBox();
        songMachine.go();
    }

    void go(){
        try(FileReader fileReader = new FileReader("/home/pacmanface/projects/headFirst/collections/songsLog.txt");
            BufferedReader reader = new BufferedReader(fileReader)){
                String line;
                while ((line = reader.readLine())!=null) {
                    addText(line);
                }

        }catch(IOException ioex){
            ioex.printStackTrace();
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    void addText(String line){
        if(line!=null){
            String[] lArr = line.split("/");
            list.add(lArr[0]);
        }
    }
}
