package com.headfirst.pacmanface;

public class ParallelRunnable implements Runnable {
    @Override
    public void run() {
        doStuff();
        System.out.println("---------------------------------------------------");
        doCriticalStuff();
        System.out.println("---------------------------------------------------");
        doExtrimStuff();
    }

    void doStuff(){
        System.out.println(Thread.currentThread().getName()+" stuff");
    }

    synchronized void doCriticalStuff(){
        System.out.println(Thread.currentThread().getName()+" critical stuff");
    }
    
    synchronized void doExtrimStuff(){
        System.out.println(Thread.currentThread().getName()+" extrim stuff");
    }

}