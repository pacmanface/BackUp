package com.pacmanface.smarthome.deviceinterfaces;

import com.pacmanface.smarthome.DeviceInterface;

public class Door extends DeviceInterface {
    
    public Door(){
        status = "closed";
    }

    public void performe(int i){
        switch(i){
            case 0: status = "open"; break;
            case 1: status = "closed"; break;
            default: System.out.println("choose 1/0 to close/open the door");
        }
        printDeviceStatus();
    }
}
