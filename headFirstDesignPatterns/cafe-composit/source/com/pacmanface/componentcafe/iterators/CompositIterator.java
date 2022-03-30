package com.pacmanface.componentcafe.iterators;

import java.util.Iterator;
import java.util.Stack;

import com.pacmanface.componentcafe.Component;

public class CompositIterator implements Iterator<Component> {

    Stack<Iterator<Component>> stack = new Stack<>();

    public CompositIterator(Iterator<Component> iterator){
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        else{
            Iterator<Component> iterator = stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            } else return true;
        }
    }

    @Override
    public Component next() {
        if(hasNext()){
            Iterator<Component> iterator = stack.peek();
            Component component = iterator.next();
            stack.push(component.createIterator());
            return component;
        }else return null;
    }
}
