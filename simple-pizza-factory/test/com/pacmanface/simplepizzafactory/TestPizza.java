package com.pacmanface.simplepizzafactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPizza{

    private static final String CHEESEE = "cheesee";

    @Test()
    public static void simpleTestOne(){
        Assert.assertEquals(CHEESEE, SimplePizzaFactory.createPizza(CHEESEE).type);
    }
}