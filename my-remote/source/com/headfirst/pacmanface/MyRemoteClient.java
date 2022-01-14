package com.headfirst.pacmanface;

import java.rmi.Naming;

public class MyRemoteClient {
    
    public static void main(String[] args) {
        MyRemoteClient client = new MyRemoteClient();
        client.go();
    }

    void go(){
        try {
            MyRemoteInterface remoteInterface = (MyRemoteInterface) Naming.lookup("rmi//:127.0.0.1/Remote Hello");
            String hello = remoteInterface.helloRMI();
            System.out.println(hello);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
