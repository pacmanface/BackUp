package com.headfirst.pacmanface;

import java.io.*;
import java.util.*;

public class JukeBox2 {
    
    ArrayList<Song> list = new ArrayList<>();

    void go(){
        try(FileReader fileReader = new FileReader("/home/pacmanface/planB/headFirst/jukebox/res/newSongsLog.txt");
            BufferedReader reader = new BufferedReader(fileReader)){
                String line;
                while ((line = reader.readLine())!=null) {
                    addText(line);
                }
        }catch(IOException ioex){
            ioex.printStackTrace();
        }
        Collections.sort(list);
    }

    void addText(String line){
        if(line!=null){
            String[] lArr = line.split("/");
            list.add(new Song(lArr[0],lArr[1],lArr[2],Integer.parseInt(lArr[3])));
        }
    }
}
