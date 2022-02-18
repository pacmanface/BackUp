package com.pacmanface.lowcasereader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestMyReader {

    public static void main(String[] args) {
        try (InputStream in = new MyLowerCaseReader(new BufferedInputStream(new FileInputStream("res/text.txt")))) {
            int c;
            while((c = in.read())>=0){
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
