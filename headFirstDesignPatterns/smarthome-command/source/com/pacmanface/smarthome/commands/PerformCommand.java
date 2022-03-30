package com.pacmanface.smarthome.commands;

import com.pacmanface.smarthome.*;

public class PerformCommand implements Command {
    
    private Device device;

    public PerformCommand(Device d){
        device = d;
    }

    public void execute(){
        device.executeInterfaces();
    }
}
