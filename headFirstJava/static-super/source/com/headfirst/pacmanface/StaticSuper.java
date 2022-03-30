package com.headfirst.pacmanface;

public class StaticSuper {

    static{
        System.out.println("StaticSuper static block");
    }

    StaticSuper(){
        System.out.println("StaticSuper constructor");
    }
}