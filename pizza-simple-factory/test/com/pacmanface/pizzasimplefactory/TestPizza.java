package com.pacmanface.pizzasimplefactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.*;

public class TestPizza{

    private static final String TYPE = "Cheesee";

    @Test()
    public void simpleTestOne(){
        assertEquals(TYPE, PizzaSimpleFactory.createPizza(TYPE).type);
    }
}