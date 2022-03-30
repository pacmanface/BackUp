package com.pacmanface.defaultcafe;

import java.util.*;

public class SandwichIterator implements Iterator<MenuItem> {

    MenuItem[] menu = null;
    int number = 0;

    public SandwichIterator(MenuItem[]m){
        menu=m;
    }

    @Override
    public boolean hasNext() {
        int bumber = number+1;
        if(bumber<menu.length && menu[bumber]!=null) return true;
        return false;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menu[number];
        number++;
        return menuItem;
    }
}
