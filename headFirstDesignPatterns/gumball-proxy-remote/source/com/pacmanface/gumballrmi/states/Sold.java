package com.pacmanface.gumballrmi.states;

import com.pacmanface.gumballrmi.*;

public class Sold extends State{
    public Sold(Gumball g){
        gumball = g;
    }

    @Override
    public void dispence() {
        gumball.deliver();
    }
}