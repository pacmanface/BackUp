package com.pacmanface.smarthome2.devices;

import com.pacmanface.smarthome2.*;
import com.pacmanface.smarthome2.deviceinterfaces.*;

public class SimpleBoiler extends Device {
    public SimpleBoiler(){
        funcs = new DeviceInterface[]{new BoilerTemperature(), new Timer()};
    }
}
