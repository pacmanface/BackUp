package com.headfirst.pacmanface;
import java.util.ArrayList;

class V3Radiator extends V2Radiator{
    V3Radiator(ArrayList<SimUnit> list){
        super(list);
        for (int i = 0; i < 10; i++) {
            list.add(new SimUnit("V3Radiator"));
            System.out.println("added V3Radiator #"+i);
        }
    }
}