package com.headfirst.pacmanface;

import java.rmi.*;

interface MyRMIInterface extends Remote{
    String helloRMI() throws RemoteException;
}