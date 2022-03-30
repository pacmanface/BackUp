package com.pacmanface.smarthome2.deviceinterfaces;

import com.pacmanface.smarthome2.*;

public class Volume extends DeviceInterface { 
    public Volume(){
        parameterName = "volume";
        safety = new int[]{0,100};
    }
}
