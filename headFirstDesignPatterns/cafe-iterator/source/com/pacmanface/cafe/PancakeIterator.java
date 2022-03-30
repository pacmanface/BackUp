package com.pacmanface.cafe;

import java.util.*;

public class PancakeIterator implements MenuIterator {

    ArrayList<MenuItem> menu = null;
    int number = 0;

    public PancakeIterator(ArrayList<MenuItem> m){
        menu=m;
    }

    @Override
    public boolean hasNext() {
        int bumber = number+1;
        if(bumber<menu.size() && menu.get(bumber)!=null) return true;
        return false;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menu.get(number);
        number++;
        return menuItem;
    }
}
