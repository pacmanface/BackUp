package com.pacmanface.smarthome;

public abstract class Device {
    
    protected String deviceName ="you can't see me";
    protected DeviceInterface[] funcs = null;
    protected int[] params = null;

    public void setFuncsParams(int[] p){
        params = p;
    }

    public void on(){
        System.out.println(deviceName+" is ON");
    }

    public void off(){
        System.out.println(deviceName+" is OFF");
    }

    public void executeInterfaces(){
        if(funcs.length==params.length){
            for (int i = 0; i < funcs.length; i++) {
                funcs[i].performe(params[i]);
            }
        }else System.out.print("funcs and params quantity is not equals!");
    }
}
