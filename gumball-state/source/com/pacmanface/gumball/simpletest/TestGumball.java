package com.pacmanface.gumball.simpletest;

import com.pacmanface.gumball.*;

public class TestGumball{
    public static void main(String[] args) {
        Gumball gumball = new Gumball(12);
        System.out.println(gumball);
        for (int i = 0; i < 13; i++) {
            gumball.insertQuart();
            gumball.turnLever();
            System.out.println(gumball);
        }
    }
}