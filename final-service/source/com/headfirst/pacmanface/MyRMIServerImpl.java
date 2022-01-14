package com.headfirst.pacmanface;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class MyRMIServerImpl extends UnicastRemoteObject implements MyRMIServer{
    
    HashMap<String,MyService> map;

    public MyRMIServerImpl() throws RemoteException {
        setUpServices();
    }

    private void setUpServices(){
        map = new HashMap<>();
        map.put("Dice Rolling Service", new DiceService());
        map.put("Day of the Week Service", new DayOfTheWeekService());
        map.put("Visual Music Service", new MiniMusicService());
    }

    public Object[] getServiceList() {
        System.out.println("in remote");
        return map.keySet().toArray();
    }

    public MyService getService(Object key) throws RemoteException{
        MyService theService = map.get((String) key);
        return theService;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("MyRMIServer", new MyRMIServerImpl());
            System.out.println("RMIServer is running!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
