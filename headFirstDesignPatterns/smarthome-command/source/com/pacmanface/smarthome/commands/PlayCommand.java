package com.pacmanface.smarthome.commands;

import com.pacmanface.smarthome.*;

public class PlayCommand implements Command {
    
    private ElectronicDevice device;

    public PlayCommand(ElectronicDevice d){
        device = d;
    }

    public void execute(){
        device.play();
    }
}
