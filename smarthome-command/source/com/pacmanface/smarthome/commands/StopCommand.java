package com.pacmanface.smarthome.commands;

import com.pacmanface.smarthome.*;

public class StopCommand implements Command {
    
    private ElectronicDevice device;

    public StopCommand(ElectronicDevice d){
        device = d;
    }

    public void execute(){
        device.stop();
    }
}
