package com.headfirst.pacmanface;
import java.util.*;

class TestLifeSupportSim{

    public static void main(String[] args) {
        ArrayList<SimUnit> list =new ArrayList<>();
        //V2Radiator v2Radiator = new V2Radiator(list);
        V3Radiator v3Radiator = new V3Radiator(list);
        RetentionBot retentionBot = new RetentionBot(list);
        checkPowerConsumption(list);
    }
    static void checkPowerConsumption(List list){
        int result=0;
        for (Object object : list) {
            SimUnit simUnit = (SimUnit) object;
            result+=simUnit.powerUse();
        }
        System.out.println("Consumed power is "+result+"kw");
    }
}