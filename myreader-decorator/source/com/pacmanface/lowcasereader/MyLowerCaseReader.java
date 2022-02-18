package com.pacmanface.lowcasereader;

import java.io.*;

public class MyLowerCaseReader extends FilterInputStream {
    
    public MyLowerCaseReader(InputStream in){
        super(in);
    }

    public int read() throws IOException{
        int c = in.read();
        return c == -1 ? c : Character.toLowerCase((char)c);
    }

    public int read(byte[]b,int off, int len) throws IOException{
        int res = in.read(b, off, len);
        for (int i = off; i < off+len; i++) {
            b[i]=(byte)(Character.toLowerCase((char)b[i]));
        }
        return res;
    }
}
