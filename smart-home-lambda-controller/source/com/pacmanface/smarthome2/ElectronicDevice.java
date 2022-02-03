package com.pacmanface.smarthome2;

public abstract class ElectronicDevice extends Device{
    
    protected String programm = "no programm";

    public void setProgramm(String p){
        programm = p;
    }

    public void play(){
        System.out.println(deviceName+" is playing "+programm);
    }
    
    public void pause(){
        System.out.println(deviceName+" on pause "+programm);
    }
    
    public void stop(){
        System.out.println(deviceName+" has stopped "+programm);
    }
}
