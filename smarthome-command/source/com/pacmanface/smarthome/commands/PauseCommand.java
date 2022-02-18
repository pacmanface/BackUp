package com.pacmanface.smarthome.commands;

import com.pacmanface.smarthome.*;

public class PauseCommand implements Command {
    
    private ElectronicDevice device;

    public PauseCommand(ElectronicDevice d){
        device = d;
    }

    public void execute(){
        device.pause();
    }
}
