package com.pacmanface.smarthome;

public abstract class ElectronicDevice extends Device{
    
    public void play(){
        System.out.println(deviceName+" is playing");
    }
    
    public void pause(){
        System.out.println(deviceName+" on pause");
    }
    
    public void stop(){
        System.out.println(deviceName+" has stopped");
    }
    
    abstract void setFunction();
}
