package com.pacmanface.componentcafe; 

public abstract class MenuComponent {
    
    protected String name;
    protected String description;

    public void add(MenuComponent menuItem){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuItem){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
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
}
