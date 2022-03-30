package com.pacmanface.smarthome;

public interface Controller {
    void invoke();
    void setCommand(Command...command);
}