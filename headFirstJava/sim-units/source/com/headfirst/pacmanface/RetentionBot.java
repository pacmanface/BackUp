package com.headfirst.pacmanface;
import java.util.ArrayList;

class RetentionBot{
    RetentionBot(ArrayList<SimUnit> list){
        int findProportion = (int) (list.size()*4)/3;
        System.out.println("proportion for Retention machine is "+findProportion);
        for (int i = 0; i < findProportion; i++) {
            list.add(new SimUnit("Retention machine"));
            System.out.println("added Rettention machine #"+i);
        }
    }
}