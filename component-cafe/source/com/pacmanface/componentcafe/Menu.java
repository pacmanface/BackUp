package com.pacmanface.componentcafe;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Menu extends MenuComponent {
    
    public ArrayList<MenuComponent> components = new ArrayList<>();

    @Override
    public void add(MenuComponent component) {
        components.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        components.remove(component);
    }

    @Override
    public MenuComponent getChild(int i) {
        return components.get(i);
    }

    @Override
    public void print() {
        System.out.println(getName());
        System.out.println(getDescription());
        Iterator<MenuComponent> iterator = components.iterator();
        while(iterator.hasNext()){
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }
}
