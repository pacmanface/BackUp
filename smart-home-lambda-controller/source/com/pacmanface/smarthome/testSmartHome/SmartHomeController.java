package com.pacmanface.smarthome.testSmartHome;

import com.pacmanface.smarthome.Command;
import com.pacmanface.smarthome.Controller;

public class SmartHomeController implements Controller{
    private Command[] commands;
    
    public void setCommand(Command...cds){
        commands=cds;
    }

    public void invoke(){
        for (Command command : commands) {
            command.execute();
        }
    }
}
