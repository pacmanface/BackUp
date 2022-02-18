package com.pacmanface.smarthome.commands;

import com.pacmanface.smarthome.*;

public class OffCommand implements Command {
    
    private Device device;

    public OffCommand(Device d){
        device = d;
    }

    public void execute(){
        device.off();
    }
}
