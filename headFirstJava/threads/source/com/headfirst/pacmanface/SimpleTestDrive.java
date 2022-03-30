package com.headfirst.pacmanface;

public class SimpleTestDrive {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int index = 0; index < 100; index++) {
            try {
                //Thread.sleep(100);
                System.out.println("main stack high");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
}
