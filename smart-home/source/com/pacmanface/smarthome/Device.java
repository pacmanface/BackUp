package com.pacmanface.smarthome;

public abstract class Device {
    
    protected String deviceName = getClass().getSimpleName();
    protected DeviceInterface[] funcs = null;
    protected int[] params = null;

    public DeviceInterface[] getFuncs(){
        return funcs;
    }

    public int[] getParams(){
        return params;
    }

    public void setFuncsParams(int[] p){
        params = p;
    }

    public void on(){
        System.out.println(deviceName+" is ON");
    }

    public void off(){
        System.out.println(deviceName+" is OFF");
    }

    public void showDIStatuses(){
        if(funcs!=null){
            for (DeviceInterface deviceInterface : funcs) {
                deviceInterface.printDIStatus();
            }
        }
    }

    public void executeInterfaces(){
        if(funcs.length==params.length){
            for (int i = 0; i < funcs.length; i++) {
                funcs[i].performe(params[i]);
            }
        }else System.out.println("funcs and params quantity is not equals!");
    }
}
