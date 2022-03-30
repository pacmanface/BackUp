package com.pacmanface.smarthome.commands;

import com.pacmanface.smarthome.Command;
import com.pacmanface.smarthome.Device;

public class OnCommand implements Command {
    
    private Device device;

    public OnCommand(Device d){
        device = d;
    }

    public void execute(){
        device.on();
    }
}
