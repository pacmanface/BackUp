package com.pacmanface.smarthome.commands;

import java.io.*;
import java.util.*;

import com.pacmanface.smarthome.*;

public class SetCommand implements Command {
    
    private Device device;

    public SetCommand(Device d){
        device = d;
    }

    public void execute(){
        device.showDIStatuses();
        try (Scanner scanner = new Scanner(new InputStreamReader(System.in))) {
            int[] params = new int[device.getFuncs().length];
            int i = 0;
            while(i<params.length){
                System.out.println("please, set a parameter");
                int x = scanner.nextInt();
                params[i] = x;
                i++;
            }
            device.setFuncsParams(params);
            System.out.println("new device parameters "+Arrays.toString(device.getParams()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
