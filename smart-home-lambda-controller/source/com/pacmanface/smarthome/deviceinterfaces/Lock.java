package com.pacmanface.smarthome.deviceinterfaces;

import com.pacmanface.smarthome.DeviceInterface;

public class Lock extends DeviceInterface {
    
    public Lock(){
        status = "locked";
    }

    public void performe(int i){
        switch(i){
            case 0: status = "unlocked"; break;
            case 1: status = "locked"; break;
            default: System.out.println("choose 1/0 to lock/unlock the lock");
        }
        printDIStatus();
    }
}
