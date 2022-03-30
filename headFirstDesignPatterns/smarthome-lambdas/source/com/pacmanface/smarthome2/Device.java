package com.pacmanface.smarthome2;

import java.io.*;
import java.util.*;

public abstract class Device {
    
    protected String deviceName = getClass().getSimpleName();
    protected DeviceInterface[] funcs = null;

    public void on(){
        showDIStatuses();
        System.out.println(deviceName+" is ON");
    }

    public void off(){
        if(funcs!=null){
            for (DeviceInterface deviceInterface : funcs) {
                deviceInterface.performe(0);
            }
            showDIStatuses();
        }
        System.out.println(deviceName+" is OFF");
    }

    protected void showDIStatuses(){
        if(funcs!=null){
            for (DeviceInterface deviceInterface : funcs) {
                deviceInterface.printDIStatus();
            }
        }else System.out.print("No DI");
    }

    public void executeDI(){
        showDIStatuses();
        if(funcs!=null){
            int[] params = null;
            try (Scanner scanner = new Scanner(new InputStreamReader(System.in))) {
                params = new int[funcs.length];
                int i = 0;
                while(i<params.length){
                    System.out.println("please, set a parameter");
                    int x = scanner.nextInt();
                    params[i] = x;
                    i++;
                }
                for (int j = 0; j < funcs.length; j++) {
                    funcs[j].performe(params[j]);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("Connection failed, try again");
            }
        }
    }
}
