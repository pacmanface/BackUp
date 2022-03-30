package com.pacmanface.smarthome2.deviceinterfaces;

import com.pacmanface.smarthome2.DeviceInterface;

public class Light extends DeviceInterface {
    public Light(){
        parameterName = "light volume";
        safety = new int[]{0,100};
    }
}
