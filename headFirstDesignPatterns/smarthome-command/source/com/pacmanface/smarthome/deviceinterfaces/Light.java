package com.pacmanface.smarthome.deviceinterfaces;

import com.pacmanface.smarthome.DeviceInterface;

public class Light extends DeviceInterface {
    
    private int lightVolume;

    public Light(){
        status = "disable";
        lightVolume = 0;
    }

    public void performe(int i){
        if(i==0){
            status="disable";
            lightVolume=0;
        }
        else if(i>0&&i<100){
            status = "able"; lightVolume = i;
        } 
        else System.out.println("choose 0-100 to set light volume");
        
        printDIStatus();
        System.out.println("device light volume is "+lightVolume);
    }
}
