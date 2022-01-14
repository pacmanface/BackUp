package com.headfirst.pacmanface;

import java.rmi.*;

interface MyRemoteInterface extends Remote{
    String helloRMI() throws RemoteException;
}