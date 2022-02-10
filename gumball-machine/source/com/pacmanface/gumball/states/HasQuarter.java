package com.pacmanface.gumball.states;

import com.pacmanface.gumball.Gumball;
import com.pacmanface.gumball.State;

public class HasQuarter extends State{

    public HasQuarter(Gumball g){
        gumball=g;
    }

    @Override
    public void turnLever() {
        if(gumball.getGums()>0){
            System.out.println("Yaas boss! Candy in progress!");
            gumball.setState(gumball.getSold());
            int winner = (int) Math.random()*10;
            if(winner==4) gumball.setState(gumball.getWinnerState());
        }else{
            ejectQuart();
            gumball.setState(gumball.getSoldOut());
        }
    }

    @Override
    public void ejectQuart() {
        System.out.println("Yaas boss! Your quarter.");
        gumball.setState(gumball.getNoQuarter());
    }
}