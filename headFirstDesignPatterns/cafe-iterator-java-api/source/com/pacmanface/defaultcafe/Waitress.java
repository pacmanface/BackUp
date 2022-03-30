package com.pacmanface.defaultcafe;

import java.util.Iterator;

public class Waitress {
    public void printMenu(Menu...menus){
        for (Menu menu : menus) {
            Iterator<MenuItem> iterator = menu.createIterator();
            System.out.print("\nMENU\n");
            while(iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }
    }
}
