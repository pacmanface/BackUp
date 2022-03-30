package com.pacmanface.gumballrmi.states;

import com.pacmanface.gumballrmi.*;

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