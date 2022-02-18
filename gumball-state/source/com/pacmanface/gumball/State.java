package com.pacmanface.gumball;

public abstract class State{

    public Gumball gumball;

    public void insertQuart(){imposibleOperation();}

    public void ejectQuart(){imposibleOperation();}

    public void turnLever(){imposibleOperation();}

    public void dispence(){imposibleOperation();}

    protected void imposibleOperation(){
        System.out.println("imposible operation");
    }
}
