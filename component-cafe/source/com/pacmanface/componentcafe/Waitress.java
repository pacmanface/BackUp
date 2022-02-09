package com.pacmanface.componentcafe;

import java.util.Iterator;

public class Waitress {

    Component component;

    public Waitress(Component c){
        component = c;
    }

    public void printMenu(){
        component.print();
    }

    public void printVegetarian(){
        Iterator<Component> iterator = component.createIterator();
        while(iterator.hasNext()){
            Component cmp = iterator.next();
            try{
                if(cmp.isVegan()) cmp.print();
            }catch(UnsupportedOperationException uex){
                //uex.printStackTrace();
            }
        }
    }
}
