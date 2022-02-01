package com.pacmanface.smarthome.devices;

import com.pacmanface.smarthome.Device;
import com.pacmanface.smarthome.DeviceInterface;
import com.pacmanface.smarthome.deviceinterfaces.Door;
import com.pacmanface.smarthome.deviceinterfaces.Light;
import com.pacmanface.smarthome.deviceinterfaces.Temperature;

public class SimpleFridge extends Device{
    public SimpleFridge(){
        funcs = new DeviceInterface[]{new Door(),new Light(),new Temperature()};
    }
}
