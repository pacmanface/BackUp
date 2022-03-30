package com.headfirst.pacmanface;

public class TestBeatBox {
    public static void main(String[] args) {
        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new BeatBoxServer().go();
            }
        });
        serverThread.start();
        new BeatBox().startUp("petya");
    }
}
