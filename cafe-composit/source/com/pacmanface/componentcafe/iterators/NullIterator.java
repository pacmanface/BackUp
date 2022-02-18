package com.pacmanface.componentcafe.iterators;

import java.util.Iterator;

import com.pacmanface.componentcafe.Component;

public class NullIterator implements Iterator<Component> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Component next() {
        return null;
    }
}
