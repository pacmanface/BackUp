import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class JukeBox2 {
    
    ArrayList<Song> list = new ArrayList<>();

    public static void main(String[] args) {
        JukeBox2 songMachine = new JukeBox2();
        songMachine.go();
    }

    void go(){
        try(FileReader fileReader = new FileReader("/home/pacmanface/projects/headFirst/collections/newSongsLog.txt");
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
        System.out.println();
        System.out.println(list);
    }

    void addText(String line){
        if(line!=null){
            String[] lArr = line.split("/");
            list.add(new Song(lArr[0],lArr[1],lArr[2],Integer.parseInt(lArr[3])));
        }
    }
}
