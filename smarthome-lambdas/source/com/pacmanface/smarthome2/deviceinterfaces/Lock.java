package com.pacmanface.smarthome2.deviceinterfaces;

import com.pacmanface.smarthome2.DeviceInterface;

public class Lock extends DeviceInterface {
    
    public Lock(){
        status = "locked";
    }

    public void performe(int i){
        switch(i){
            case 1: status = "unlocked"; break;
            case 0: status = "locked"; break;
            default: System.out.println("choose 1/0 to lock/unlock the lock");
        }
        printDIStatus();
    }
}
