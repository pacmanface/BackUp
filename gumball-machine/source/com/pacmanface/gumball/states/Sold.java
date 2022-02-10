package com.pacmanface.gumball.states;

import com.pacmanface.gumball.Gumball;
import com.pacmanface.gumball.State;

public class Sold extends State{
    public Sold(Gumball g){
        gumball = g;
    }

    @Override
    public void dispence() {
        gumball.deliver();
    }
}