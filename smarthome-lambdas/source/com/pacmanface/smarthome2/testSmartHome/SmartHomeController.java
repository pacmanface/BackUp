package com.pacmanface.smarthome2.testSmartHome;

import com.pacmanface.smarthome2.*;

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
