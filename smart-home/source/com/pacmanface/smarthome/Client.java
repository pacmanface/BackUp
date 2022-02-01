package com.pacmanface.smarthome;

import com.pacmanface.smarthome.commands.*;
import com.pacmanface.smarthome.devices.*;

public class Client {

    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        //SimpleBoiler boiler = new SimpleBoiler();
        SimpleFridge fridge = new SimpleFridge();

        //controller.setCommand(new OnCommand(boiler),new SetCommand(boiler),new PerformCommand(boiler),new OffCommand(boiler));
        //controller.invoke();

        controller.setCommand(new OnCommand(fridge),new SetCommand(fridge),new PerformCommand(fridge),new OffCommand(fridge));
        controller.invoke();
    }
    
}
