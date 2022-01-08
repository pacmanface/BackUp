package com.headfirst.pacmanface;

import java.io.*;
import java.net.*;
import java.util.*;

public class VerySimpleChatServer {
    
    ArrayList<PrintWriter> clientOutputStreams;

    void go(){
        clientOutputStreams = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true){
                Socket clientSocket = serverSocket.accept();   
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
                System.out.println("got connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public class ClientHandler implements Runnable{
        
        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket clientSocket){
            try {
                socket = clientSocket;
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(inputStreamReader);                 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while((message=reader.readLine())!=null){
                    System.out.println("read "+message);
                    tellEveryone(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void tellEveryone(String message){
        Iterator<PrintWriter> iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                PrintWriter writer = iterator.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) {
                //TODO: handle exception
                ex.printStackTrace();
            }
        }

        /*
        for (PrintWriter printWriter : clientOutputStreams) {
            try {
                printWriter.println(message);
                printWriter.flush();        
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */
    }
}
