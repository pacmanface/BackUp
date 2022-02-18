package com.pacmanface.gumballrmi.simpletest;

import java.rmi.RemoteException;

import com.pacmanface.gumballrmi.*;

public class TestGumball{
    public static void main(String[] args) {
        try {
            Gumball chicago = new Gumball(12,"chicago");
            Gumball seatle = new Gumball(20,"seatle");
            Gumball tokyo = new Gumball(30,"tokyo");
            Gumball moscow = new Gumball(10,"moscow");
            System.out.println(chicago);
            System.out.println(seatle);
            System.out.println(tokyo);
            System.out.println(moscow);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}