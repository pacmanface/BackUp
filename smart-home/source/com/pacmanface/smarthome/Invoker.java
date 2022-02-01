package com.pacmanface.smarthome;

public interface Invoker {
    void invoke();
    void setCommand(Command...command);
}