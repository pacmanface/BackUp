package com.pacmanface.smarthome;

public abstract class DeviceInterface {
    
    protected String status = "abstract";

    public void printDeviceStatus(){
        System.out.println();
        System.out.print("device status is ");
        System.out.print(status);
    }
    
    public abstract void performe(int i);
}
