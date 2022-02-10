package com.pacmanface.gumball.states;

import com.pacmanface.gumball.Gumball;
import com.pacmanface.gumball.State;

public class Sold extends State{
    public Sold(Gumball g){
        gumball = g;
    }

    @Override
    public void dispence() {
        int x = gumball.getGums()-1;
        if(x>0){
            System.out.println("Take your candy, please.");
            gumball.setGums(x);
            gumball.setState(gumball.getNoQuarter());
        }else{
            gumball.setGums(0);
            gumball.setState(gumball.getSoldOut());
        }
    }
}