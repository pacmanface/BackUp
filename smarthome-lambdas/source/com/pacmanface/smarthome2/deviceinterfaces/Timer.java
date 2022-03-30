package com.pacmanface.smarthome2.deviceinterfaces;

import com.pacmanface.smarthome2.DeviceInterface;

public class Timer extends DeviceInterface {
    public Timer(){
        parameterName = "timer";
        safety = new int[]{0,60};
    }
}
