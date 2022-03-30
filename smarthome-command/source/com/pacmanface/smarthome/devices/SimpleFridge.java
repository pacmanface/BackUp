package com.pacmanface.smarthome.devices;

import com.pacmanface.smarthome.*;
import com.pacmanface.smarthome.deviceinterfaces.*;

public class SimpleFridge extends Device{
    public SimpleFridge(){
        funcs = new DeviceInterface[]{new Door(),new Light(),new Temperature()};
    }
}
