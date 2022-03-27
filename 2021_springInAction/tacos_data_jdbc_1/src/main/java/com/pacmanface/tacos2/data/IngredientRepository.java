package com.pacmanface.tacos2.data;

import com.pacmanface.tacos2.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
