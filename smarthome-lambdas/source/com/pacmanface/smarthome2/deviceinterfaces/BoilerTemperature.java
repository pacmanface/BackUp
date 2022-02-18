package com.pacmanface.smarthome2.deviceinterfaces;

import com.pacmanface.smarthome2.*;

public class BoilerTemperature extends DeviceInterface {
    public BoilerTemperature(){
        parameterName = "temperrature";
        safety = new int[]{0,100};
    }
}
