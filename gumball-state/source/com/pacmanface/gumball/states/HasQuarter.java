package com.pacmanface.gumball.states;

import com.pacmanface.gumball.Gumball;
import com.pacmanface.gumball.State;

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