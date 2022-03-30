package com.pacmanface.smarthome;

public abstract class DeviceInterface {
    
    protected String status = "abstract";

    public void printDIStatus(){
        System.out.println(getClass().getSimpleName()+" interface status is "+status);
    }
    
    public abstract void performe(int i);
}
