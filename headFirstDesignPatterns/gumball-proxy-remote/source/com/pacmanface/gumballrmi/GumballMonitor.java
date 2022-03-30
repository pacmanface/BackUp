package com.pacmanface.gumballrmi;

import java.rmi.*;

public class GumballMonitor {
    GumballRemote gumball;
    
    public GumballMonitor(GumballRemote g){
        gumball = g;
    }

    public void report(){
        try{
            System.out.println(gumball.getLocation());
            System.out.println(gumball.getGums());
            System.out.println(gumball.getState().getClass().getSimpleName());
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }

}
