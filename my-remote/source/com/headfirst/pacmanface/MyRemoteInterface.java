package com.headfirst.pacmanface;

import java.rmi.*;

interface MyRemoteInterface extends Remote{
    String sayHello() throws RemoteException;
}
