package com.headfirst.pacmanface;

import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteInterfaceImpl extends UnicastRemoteObject implements MyRemoteInterface{

    @Override
    public String sayHello(){
        return "wow, I see it after 3 book";
    }

    public MyRemoteInterfaceImpl() throws RemoteException{}

    public static void main(String[] args) {
        try {
            MyRemoteInterface impl = new MyRemoteInterfaceImpl();
            Naming.rebind("anotherShittyService", impl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
