package com.pacmanface.gumball.states;

import com.pacmanface.gumball.Gumball;
import com.pacmanface.gumball.State;

public class SoldOut extends State{
    public SoldOut(Gumball g){
        gumball=g;
    }

    @Override
    public void insertQuart() {
        System.out.println("Please, refill machine");
    }

    @Override
    public void dispence() {
        System.out.println("Please, refill machine");
    }

    @Override
    public void turnLever() {
        System.out.println("Please, refill machine");
    }
}