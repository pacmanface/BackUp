package com.pacmanface.pizzaabstractfactory.hubs;

import com.pacmanface.pizzaabstractfactory.IngredientFactory;
import com.pacmanface.pizzaabstractfactory.concreteingredients.*;
import com.pacmanface.pizzaabstractfactory.ingredients.*;


public class NYIngredientFactory implements IngredientFactory{

    public Dough createDough(){
        return new ThinCrunchDough();
    }
    
    public Clam createClam(){
        return new FreshClam();
    }

    public Cheese createCheese(){
        return new Parmejano();
    }

    public Sauce createSauce(){
        return new Marinara();
    }

    public Pepperoni createPepperoni(){
        return new SlicedPepperoni();
    }

    public Veggis[] createVeggis(){
        return new Veggis[]{new Tomato(),new BlackOlive(),new RedSweetPepper(),new Spinach(), new ChiliPepper()};
    }
}
