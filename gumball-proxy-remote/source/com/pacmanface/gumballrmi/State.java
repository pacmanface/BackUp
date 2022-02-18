package com.pacmanface.gumballrmi;

import java.io.*;

public abstract class State implements Serializable{

    protected static final long serialVersionUID = 2L;
    public transient Gumball gumball;

    public void insertQuart(){imposibleOperation();}

    public void ejectQuart(){imposibleOperation();}

    public void turnLever(){imposibleOperation();}

    public void dispence(){imposibleOperation();}

    protected void imposibleOperation(){
        System.out.println("imposible operation");
    }
}
