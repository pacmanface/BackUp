package com.pacmanface.smarthome.deviceinterfaces;

import com.pacmanface.smarthome.DeviceInterface;

public class Volume extends DeviceInterface {
    
    private int soundVolume;

    public Volume(){
        status = "disable";
        soundVolume = 0;
    }

    public void performe(int i){
        if(i==0){
            status="disable";
            soundVolume=0;
        }
        else if(i>0&&i<100){
            status = "able"; soundVolume = i;
        } 
        else System.out.println("choose 0-100 to set volume");
        
        printDIStatus();
        System.out.println("device volume is "+soundVolume);
    }
}
