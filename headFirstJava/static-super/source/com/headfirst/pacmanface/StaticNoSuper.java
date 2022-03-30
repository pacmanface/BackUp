package com.headfirst.pacmanface;

public class StaticNoSuper extends StaticNotSoSuper {
    
    static{
        System.out.println("StaticNoSuper static block");
    }
    
    StaticNoSuper(){
        System.out.println("StaticNoSuper constructor");
    }
    
    public static void main(String[] args) {
        System.out.println("StaticNoSuper main method!");
        new StaticNoSuper();
    }
}
