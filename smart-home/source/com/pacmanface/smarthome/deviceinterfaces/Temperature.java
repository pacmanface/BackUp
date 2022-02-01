package com.pacmanface.smarthome.deviceinterfaces;

import com.pacmanface.smarthome.*;

public class Temperature extends DeviceInterface {

    private int temperature;

    public Temperature(){
        status = "disable";
        temperature = 0;
    }

    public void performe(int i){
        if(i==0){
            status="disable";
            temperature=0;
        }
        else if(i>-10&&i<350){
            status = "able"; temperature = i;
        } 
        else System.out.println("choose 0-350 to set temperature");
        
        printDeviceStatus();
        System.out.print(", temperature is "+temperature);
    }

}
