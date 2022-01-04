import java.io.*;
import java.util.*;

public class JukeBox3 {
    
    ArrayList<Song> list = new ArrayList<>();

    public static void main(String[] args) {
        JukeBox3 songMachine = new JukeBox3();
        songMachine.go();
    }

    public class TimeComparator implements Comparator<Song>{
        @Override
        public int compare(Song o1, Song o2) {
            // TODO Auto-generated method stub
            return o2.getTime()-o1.getTime();
        }        
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
        Collections.sort(list, new TimeComparator());
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
