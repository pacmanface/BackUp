package com.headfirst.pacmanface;

import java.io.*;
import java.net.*;

public class DailyAdviceClient {
    
    void go(){
        try(Socket socket = new Socket("127.0.0.1",4242);
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(is)){
                String advice = reader.readLine();
                System.out.println("READY?");
                System.out.println();
                Thread.sleep(500);
                System.out.println("Ok " + advice);
                System.out.println();
                Thread.sleep(500);
                System.out.println("that's it");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
