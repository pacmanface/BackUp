package com.pacmanface.gumballrmi.simpletest;

import java.rmi.*;

import com.pacmanface.gumballrmi.*;

public class TestMonitor {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try{
                GumballRemote gumballRemote = (GumballRemote) Naming.lookup("//localhost:1099/"+args[i]);
                new GumballMonitor(gumballRemote).report();
            }catch(Exception e){
                e.printStackTrace();
            }    
        }
    }
}
