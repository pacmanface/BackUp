package com.pacmanface.smarthome.deviceinterfaces;

import com.pacmanface.smarthome.DeviceInterface;

public class Timer extends DeviceInterface {

    private int timer;

    public Timer(){
        status = "disable";
        timer = 0;
    }

    public void performe(int i){
        if(i==0){
            status="disable";
            timer=0;
        }
        else if(i>0&&i<60){
            status = "able"; timer = i;
        } 
        else System.out.println("choose 0-60 to set timer");
        
        printDeviceStatus();
        System.out.print(", timer is "+timer);
    }
}
