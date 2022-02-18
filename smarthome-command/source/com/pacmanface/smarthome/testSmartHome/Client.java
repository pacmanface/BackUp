package com.pacmanface.smarthome.testSmartHome;

import com.pacmanface.smarthome.commands.*;
import com.pacmanface.smarthome.devices.*;

public class Client {

    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        SimpleBoiler boiler = new SimpleBoiler();

        controller.setCommand(new OnCommand(boiler),new OffCommand(boiler));
        controller.invoke();
    }
}
