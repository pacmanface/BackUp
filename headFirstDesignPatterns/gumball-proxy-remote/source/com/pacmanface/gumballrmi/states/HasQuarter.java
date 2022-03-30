package com.pacmanface.gumballrmi.states;

import com.pacmanface.gumballrmi.*;

public class HasQuarter extends State{

    public HasQuarter(Gumball g){
        gumball=g;
    }

    @Override
    public void turnLever() {
        System.out.println("Yaas boss! Candy in progress!");
        gumball.setState(gumball.getSold());
    }

    @Override
    public void ejectQuart() {
        System.out.println("Sorry boss! Your quarter.");
        gumball.setState(gumball.getNoQuarter());
    }
}