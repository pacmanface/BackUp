package com.pacmanface.gumball.states;

import com.pacmanface.gumball.Gumball;
import com.pacmanface.gumball.State;

public class WinnerState extends State{
    public WinnerState(Gumball g){
        gumball = g;
    }

    @Override
    public void dispence() {
        if(gumball.getGums()>0){
            System.out.println("You are luky today");
            gumball.getSold().dispence();
        }
    }
}