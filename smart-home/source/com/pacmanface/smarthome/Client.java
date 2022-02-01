package com.pacmanface.smarthome;

import com.pacmanface.smarthome.commands.OnCommand;
import com.pacmanface.smarthome.commands.PerformCommand;
import com.pacmanface.smarthome.devices.SimpleBoiler;

public class Client {

    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        SimpleBoiler boiler = new SimpleBoiler();

        controller.setCommand(new OnCommand(boiler));
        
        controller.setCommand(new PerformCommand(boiler));
        controller.invoke();
    }
    
}
