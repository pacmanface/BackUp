package com.pacmanface.smarthome.deviceinterfaces;

import com.pacmanface.smarthome.*;

public class Fan extends DeviceInterface {
    
    private int fanSpeed;

    public Fan(){
        status = "disable";
        fanSpeed = 0;
    }

    public void performe(int i){
        if(i==0){
            status="disable";
            fanSpeed=0;
        }
        else if(i>0&&i<3){
            status = "able"; fanSpeed = i;
        } 
        else System.out.println("choose 0-3 to able fan and set speed");
        
        printDeviceStatus();
        System.out.print(", fan speed is "+fanSpeed);
    }
}
