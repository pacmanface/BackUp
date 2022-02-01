package com.pacmanface.smarthome.devices;

import com.pacmanface.smarthome.*;
import com.pacmanface.smarthome.deviceinterfaces.Temperature;
import com.pacmanface.smarthome.deviceinterfaces.Timer;

public class SimpleBoiler extends Device {
    public SimpleBoiler(){
        deviceName = "simple boiler";
        funcs = new DeviceInterface[]{new Temperature(), new Timer()};
    }
}
