package com.pacmanface.gumball.states;

import com.pacmanface.gumball.Gumball;
import com.pacmanface.gumball.State;

public class NoQuarter extends State { 

    public NoQuarter(Gumball g){
        gumball = g; 
    }

    @Override
    public void insertQuart() {
        System.out.println("Your quarter receipt, boss!");
        gumball.setState(gumball.getHasQuarter());
    }
}