package com.pacmanface.componentcafe; 

import java.util.*;

public abstract class Component {
    
    protected String name;
    protected String description;

    public void add(Component menuItem){
        throw new UnsupportedOperationException();
    }

    public void remove(Component menuItem){
        throw new UnsupportedOperationException();
    }

    public Component getChild(int i){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void print(){
        throw new UnsupportedOperationException();
    }

    public boolean isVegan(){
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<Component> createIterator(); 
}
