package com.pacmanface.smarthome2.deviceinterfaces;

import com.pacmanface.smarthome2.*;

public class Fan extends DeviceInterface {
    public Fan(){
        parameterName = "fan speed";
        safety = new int[]{0,100};
    }
}
