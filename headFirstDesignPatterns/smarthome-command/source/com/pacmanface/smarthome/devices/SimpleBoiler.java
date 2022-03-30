package com.pacmanface.smarthome.devices;

import com.pacmanface.smarthome.*;
import com.pacmanface.smarthome.deviceinterfaces.*;

public class SimpleBoiler extends Device {
    public SimpleBoiler(){
        funcs = new DeviceInterface[]{new Temperature(), new Timer()};
    }
}
