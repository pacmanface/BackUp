package com.headfirst.pacmanface;

import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteInterfaceImpl extends UnicastRemoteObject implements MyRemoteInterface{

    @Override
    public String helloRMI(){
        return "Remote Hello World";
    }

    public MyRemoteInterfaceImpl() throws RemoteException{}

    public static void main(String[] args) {
        try {
            MyRemoteInterface implMyRMIInterface = new MyRemoteInterfaceImpl();
            Naming.bind("Remote Hello", implMyRMIInterface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
