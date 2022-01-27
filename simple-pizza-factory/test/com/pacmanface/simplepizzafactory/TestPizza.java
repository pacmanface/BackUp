package com.pacmanface.simplepizzafactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.*;

public class TestPizza{

    private static final String TYPE = "Cheesee";

    @Test()
    public void simpleTestOne(){
        assertEquals(TYPE, SimplePizzaFactory.createPizza(TYPE).type);
    }
}