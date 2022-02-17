package com.headfirst.pacmanface;

import java.rmi.Naming;

public class MyRemoteClient {
    
    public static void main(String[] args) {
        MyRemoteClient client = new MyRemoteClient();
        client.go();
    }

    void go(){
        try {
            MyRemoteInterface service = (MyRemoteInterface) Naming.lookup("//localhost:1099/anotherShittyService");
            String reply = service.sayHello();
            System.out.println(reply);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
