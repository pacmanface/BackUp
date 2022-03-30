package com.pacmanface.smarthome2;

public interface Controller {
    void invoke();
    void setCommand(Command...command);
}