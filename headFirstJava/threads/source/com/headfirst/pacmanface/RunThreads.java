package com.headfirst.pacmanface;
public class RunThreads implements Runnable {

    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread alfa = new Thread(runner);
        Thread beta = new Thread(runner);
        alfa.setName("alfa");
        beta.setName("beta");
        alfa.start();
        beta.start();
    }


    @Override
    public void run() {
        for (int i = 0; i < 250; i++) {
            System.out.println("Now working thread " + Thread.currentThread().getName());
        }
    }    
}
