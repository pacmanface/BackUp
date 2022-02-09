package com.pacmanface.componentcafe;

import java.util.ArrayList;
import java.util.Iterator;

import com.pacmanface.componentcafe.iterators.CompositIterator;

public abstract class Menu extends Component {
    
    public ArrayList<Component> menuComponents = new ArrayList<>();
    public Iterator<Component> iterator = null;

    @Override
    public void add(Component component) {
        menuComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        menuComponents.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public void print() {
        System.out.println(getName());
        System.out.println(getDescription());
        Iterator<Component> iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            Component menuComponent = iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public Iterator<Component> createIterator() {
        if(iterator==null){
            iterator = new CompositIterator(menuComponents.iterator());
        }
        return iterator;
    }
}
