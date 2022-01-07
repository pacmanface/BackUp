package com.headfirst.pacmanface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRMIInterfaceImpl extends UnicastRemoteObject implements MyRMIInterface{

    @Override
    public String helloRMI(){
        // TODO Auto-generated method stub
        return "Remote Hello World";
    }

    public MyRMIInterfaceImpl() throws RemoteException{}

    public static void main(String[] args) {
        try {
            MyRMIInterface implMyRMIInterface = new MyRMIInterfaceImpl();
            Naming.bind("Remote Hello", implMyRMIInterface);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
