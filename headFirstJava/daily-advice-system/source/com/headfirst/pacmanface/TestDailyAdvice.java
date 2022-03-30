package com.headfirst.pacmanface;

public class TestDailyAdvice {
    
    public static void main(String[] args) {
        Thread serveThread = new Thread(new DailyAdviceServer());
        serveThread.setDaemon(true);
        serveThread.start();
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    
    }
}
