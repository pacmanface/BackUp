package com.pacmanface.smarthome2.deviceinterfaces;

import com.pacmanface.smarthome2.DeviceInterface;

public class Door extends DeviceInterface {
    
    public Door(){
        status = "closed";
    }

    public void performe(int i){
        switch(i){
            case 1: status = "open"; break;
            case 0: status = "closed"; break;
            default: System.out.println("choose 1/0 to close/open the door");
        }
        printDIStatus();
    }
}
