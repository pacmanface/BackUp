package com.pacmanface.pizzaabstractfactory;

import com.pacmanface.pizzaabstractfactory.ingredients.*;

public interface IngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Clam createClam();
    Pepperoni createPepperoni();
    Veggis[] createVeggis();
}
