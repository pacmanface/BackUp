package com.pacmanface.gumballrmi.states;

import com.pacmanface.gumballrmi.*;

public class WinnerState extends State{
    public WinnerState(Gumball g){
        gumball = g;
    }

    @Override
    public void dispence() {
        int bingo = (int) (Math.random()*5);
        System.out.println("Win number is 4 your number is "+bingo);
        if(bingo==4){
            System.out.println("You are lucky today");
            gumball.deliver();
        }
    }
}