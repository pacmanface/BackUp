package com.pacmanface.smarthome;

public class SmartHomeController implements Invoker{
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
