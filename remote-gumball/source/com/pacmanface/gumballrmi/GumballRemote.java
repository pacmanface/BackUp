package com.pacmanface.gumballrmi;

import java.rmi.*;

public interface GumballRemote extends Remote {
    State getState() throws RemoteException;
    int getGums() throws RemoteException;
    String getLocation() throws RemoteException;
}
