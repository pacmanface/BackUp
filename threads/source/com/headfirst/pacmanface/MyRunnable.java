package com.headfirst.pacmanface;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }
    
    void go(){
        try {
            for (int i = 0; i <100; i++) {
                //Thread.sleep(100);
                doMore();  
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void doMore(){
        System.out.println("user thread stack high!");
    }
}
