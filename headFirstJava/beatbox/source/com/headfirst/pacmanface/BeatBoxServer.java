package com.headfirst.pacmanface;

import java.net.*;
import java.io.*;
import java.util.*;

public class BeatBoxServer {
    ArrayList<ObjectOutputStream> clientOutputStreams;

    public void go(){
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true){
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);
                System.out.println("get Connection!");
                Thread thread = new Thread(new ClientSpamBot(clientSocket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ClientSpamBot implements Runnable{
        
        Socket clientSocket;
        ObjectInputStream in;
        
        public ClientSpamBot(Socket socket){
            try {
                clientSocket = socket;
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        @Override
        public void run() {
            Object one = null;
            Object two = null;
            try {
                while((one = in.readObject())!=null) {
                    two = in.readObject();
                    System.out.print("got the pair of objects");
                    tellEveryone(one, two);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tellEveryone(Object one, Object two){
        Iterator<ObjectOutputStream> iterator = clientOutputStreams.iterator();
        while(iterator.hasNext()){
            try {
                ObjectOutputStream out = iterator.next();
                out.writeObject(one);
                out.writeObject(two);    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
