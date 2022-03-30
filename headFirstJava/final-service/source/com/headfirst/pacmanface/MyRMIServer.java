package com.headfirst.pacmanface;

import java.rmi.*;

public interface MyRMIServer extends Remote{
    Object[] getServiceList() throws RemoteException;
    MyService getService(Object serviceName) throws RemoteException;
}
