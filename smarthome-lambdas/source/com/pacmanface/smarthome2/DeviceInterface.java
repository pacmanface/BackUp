package com.pacmanface.smarthome2;

public abstract class DeviceInterface {
    
    protected String status = "disable";
    protected String parameterName = "noname";
    protected int param = 0;
    protected int[] safety = {0,0};

    public void printDIStatus(){
        System.out.println(getClass().getSimpleName()+" interface status is "+status+" "+parameterName+" "+param);
    }

    public void performe(int i){
        if(i==0){
            status="disable";
            param = 0;
        }
        else if(i>safety[0]&&i<safety[1]){
            status = "able"; param = i;
        } 
        else System.out.println("imposible param");
        printDIStatus();
    };
}
