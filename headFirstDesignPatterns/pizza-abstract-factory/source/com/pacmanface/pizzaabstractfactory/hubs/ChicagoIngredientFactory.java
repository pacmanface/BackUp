package com.pacmanface.pizzaabstractfactory.hubs;

import com.pacmanface.pizzaabstractfactory.IngredientFactory;
import com.pacmanface.pizzaabstractfactory.concreteingredients.*;
import com.pacmanface.pizzaabstractfactory.ingredients.*;

public class ChicagoIngredientFactory implements IngredientFactory{
    
    public Dough createDough(){
        return new FatSweetCheeseDough();
    }
    
    public Clam createClam(){
        return new FrozenClam();
    }

    public Cheese createCheese(){
        return new Mozarella();
    }

    public Sauce createSauce(){
        return new HotSweetTomatoSauce();
    }

    public Pepperoni createPepperoni(){
        return new SlicedPepperoni();
    }

    public Veggis[] createVeggis(){
        return new Veggis[]{new Tomato(),new BlackOlive(),new RedSweetPepper(),new Spinach(), new ChiliPepper()};
    }
}
