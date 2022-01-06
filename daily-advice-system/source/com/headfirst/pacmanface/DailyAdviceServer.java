package com.headfirst.pacmanface;

import java.io.*;
import java.net.*;

public class DailyAdviceServer implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("advice is loading ...br-br-br");
            System.out.println();
            go();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Oops Server thread made some tricks");
        }
    }
        
    void go(){
        try(ServerSocket serverSocket = new ServerSocket(4242)){
            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                pw.println(advice);
                pw.close();
                //System.out.println(advice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String[] advices = {"Drink more water","Go to gym","Find a job","Buy a car","Make a run","Walk around","Sleep 8 hours a day","Buy running suit",
    "Take a deep breath","make 20 pushups","don't eat sugar,salt & bread"};

    String getAdvice(){
        return advices[((int) (Math.random()*advices.length))];
    }

}
