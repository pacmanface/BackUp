package com.pacmanface.smarthome2.testSmartHome;

import com.pacmanface.smarthome2.devices.*;

public class Client {

    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        SimpleBoiler boiler = new SimpleBoiler();

        controller.setCommand(()->{boiler.on();boiler.executeDI();boiler.off();});
        controller.invoke();
    }
}
